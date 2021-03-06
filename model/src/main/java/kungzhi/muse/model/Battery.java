package kungzhi.muse.model;

public class Battery
        extends ActiveModel<Battery> {
    private Integer stateOfCharge = 0;
    private Integer fuelGaugeVoltage = 0;
    private Integer adcVoltage = 0;
    private Integer temperature = 0;

    public Battery() {
        this(0);
    }

    public Battery(long time) {
        super(time);
    }

    public Integer getStateOfCharge() {
        return stateOfCharge;
    }

    public void setStateOfCharge(Integer stateOfCharge) {
        this.stateOfCharge = stateOfCharge;
    }

    public Battery withStateOfCharge(Integer stateOfCharge) {
        this.stateOfCharge = stateOfCharge;
        return this;
    }

    public Integer getFuelGaugeVoltage() {
        return fuelGaugeVoltage;
    }

    public void setFuelGaugeVoltage(Integer fuelGaugeVoltage) {
        this.fuelGaugeVoltage = fuelGaugeVoltage;
    }

    public Battery withFuelGaugeVoltage(Integer fuelGaugeVoltage) {
        this.fuelGaugeVoltage = fuelGaugeVoltage;
        return this;
    }

    public Integer getAdcVoltage() {
        return adcVoltage;
    }

    public void setAdcVoltage(Integer adcVoltage) {
        this.adcVoltage = adcVoltage;
    }

    public Battery withAdcVoltage(Integer adcVoltage) {
        this.adcVoltage = adcVoltage;
        return this;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Battery withTemperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    public Float getPercentRemaining() {
        return stateOfCharge / 100f;
    }

    @Override
    public boolean sameAs(Battery battery) {
        if (stateOfCharge != null ? !stateOfCharge.equals(battery.stateOfCharge) : battery.stateOfCharge != null)
            return false;
        if (fuelGaugeVoltage != null ? !fuelGaugeVoltage.equals(battery.fuelGaugeVoltage) : battery.fuelGaugeVoltage != null)
            return false;
        if (adcVoltage != null ? !adcVoltage.equals(battery.adcVoltage) : battery.adcVoltage != null) return false;
        return temperature != null ? temperature.equals(battery.temperature) : battery.temperature == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        return sameAs((Battery) o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stateOfCharge != null ? stateOfCharge.hashCode() : 0);
        result = 31 * result + (fuelGaugeVoltage != null ? fuelGaugeVoltage.hashCode() : 0);
        result = 31 * result + (adcVoltage != null ? adcVoltage.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "time=" + time +
                ", stateOfCharge=" + stateOfCharge +
                ", fuelGaugeVoltage=" + fuelGaugeVoltage +
                ", adcVoltage=" + adcVoltage +
                ", temperature=" + temperature +
                '}';
    }

    @Override
    protected Battery newInstance() {
        return new Battery();
    }

    @Override
    protected Battery update(Battery that) {
        this.time = that.time;
        this.adcVoltage = that.adcVoltage;
        this.fuelGaugeVoltage = that.fuelGaugeVoltage;
        this.stateOfCharge = that.stateOfCharge;
        this.temperature = that.temperature;
        return this;
    }
}
