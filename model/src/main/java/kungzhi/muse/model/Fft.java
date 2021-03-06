package kungzhi.muse.model;

import java.util.List;
import java.util.stream.Stream;

import static kungzhi.lang.Functions.averageOf;

public class Fft
        extends AbstractModel {
    private final int channelIndex;
    private final List<Object> values;

    public Fft(long time, int channelIndex, List<Object> values) {
        super(time);
        this.channelIndex = channelIndex;
        this.values = values;
    }

    public int getChannelIndex() {
        return channelIndex;
    }

    public Stream<Float> values() {
        return values.stream()
                .map(Float.class::cast);
    }

    public Double average() {
        return averageOf(values(), 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Fft fft = (Fft) o;

        if (channelIndex != fft.channelIndex) return false;
        return values != null ? values.equals(fft.values) : fft.values == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + channelIndex;
        result = 31 * result + (values != null ? values.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fft{" +
                "time=" + time +
                ", channelIndex=" + channelIndex +
                ", values=" + values +
                '}';
    }
}
