package kungzhi.muse.osc.transform;

import com.illposed.osc.OSCMessage;
import com.jsoniter.any.Any;
import kungzhi.muse.model.Configuration;
import kungzhi.muse.model.Preset;
import kungzhi.muse.model.Sensor;
import kungzhi.muse.runtime.Transformer;

import static com.jsoniter.JsonIterator.deserialize;
import static java.util.Arrays.stream;
import static kungzhi.muse.osc.service.MessageAddress.CONFIGURATION;
import static kungzhi.muse.osc.transform.MessageHelper.argumentAt;

@Transformer(CONFIGURATION)
public class ConfigurationTransformer
        implements MessageTransformer<Configuration> {

    @Override
    public Configuration fromMessage(long time, OSCMessage message)
            throws Exception {
        Any json = deserialize(argumentAt(message, String.class, 0));
        Configuration configuration = new Configuration(time)
                // Global
                .withMacAddress(json.toString("mac_addr"))
                .withSerialNumber(json.toString("serial_number"))
                .withPreset(Preset.fromId(json.toString("preset")))
                // Network Protocol
                .withCompressionEnabled(json.toBoolean("compression_enabled"))
                // EEG
                .withFiltersEnabled(json.toBoolean("filters_enabled"))
                .withNotchFrequencyInHz(json.toInt("notch_frequency_hz"))
                .withEegSampleFrequencyInHz(json.toInt("eeg_sample_frequency_hz"))
                .withEegOutputFrequencyInHz(json.toInt("eeg_output_frequency_hz"))
                .withEegChannelCount(json.toInt("eeg_channel_count"));
        stream(json.toString("eeg_channel_layout").trim().split(" "))
                .map(Sensor::valueOf)
                .forEach(configuration::withEegChannelInLayout);
        return configuration
                .withEegSamplesBitWidth(json.toInt("eeg_samples_bitwidth"))
                .withEegDownSample(json.toInt("eeg_downsample"))
                .withAfeGain(json.toFloat("afe_gain"))
                // DRL/REF
                .withDrlRefDataEnabled(json.toBoolean("drlref_data_enabled"))
                .withDrlRefConversionFactor(json.toFloat("drlref_conversion_factor"))
                .withDrlRefSampleFrequencyInHz(json.toInt("drlref_sample_frequency_hz"))
                // Accelerometer
                .withAccDataEnabled(json.toBoolean("acc_data_enabled"))
                .withAccUnits(json.toString("acc_units"))
                .withAccSampleFrequencyInHz(json.toInt("acc_sample_frequency_hz"))
                // Battery
                .withBatteryDataEnabled(json.toBoolean("battery_data_enabled"))
                .withBatteryPercentRemaining(json.toInt("battery_percent_remaining"))
                .withBatteryMilliVolts(json.toInt("battery_millivolts"))
                // Error
                .withErrorDataEnabled(json.toBoolean("error_data_enabled"));
    }
}
