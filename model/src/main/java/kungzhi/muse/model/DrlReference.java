package kungzhi.muse.model;

public class DrlReference
        extends ActiveModel<DrlReference> {
    private Float drivenRightLegVoltage = 0f;
    private Float referenceVoltage = 0f;

    public DrlReference() {
        this(0);
    }

    public DrlReference(long time) {
        super(time);
    }

    public Float getDrivenRightLegVoltage() {
        return drivenRightLegVoltage;
    }

    public void setDrivenRightLegVoltage(Float drivenRightLegVoltage) {
        this.drivenRightLegVoltage = drivenRightLegVoltage;
    }

    public DrlReference withDrivenRightLegVoltage(Float drivenRightLegVoltage) {
        this.drivenRightLegVoltage = drivenRightLegVoltage;
        return this;
    }

    public Float getReferenceVoltage() {
        return referenceVoltage;
    }

    public void setReferenceVoltage(Float referenceVoltage) {
        this.referenceVoltage = referenceVoltage;
    }

    public DrlReference withReferenceVoltage(Float referenceVoltage) {
        this.referenceVoltage = referenceVoltage;
        return this;
    }

    @Override
    public boolean sameAs(DrlReference drlReference) {
        if (drivenRightLegVoltage != null ? !drivenRightLegVoltage.equals(drlReference.drivenRightLegVoltage) : drlReference.drivenRightLegVoltage != null)
            return false;
        return referenceVoltage != null ? referenceVoltage.equals(drlReference.referenceVoltage) : drlReference.referenceVoltage == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        return sameAs((DrlReference) o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (drivenRightLegVoltage != null ? drivenRightLegVoltage.hashCode() : 0);
        result = 31 * result + (referenceVoltage != null ? referenceVoltage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DrlReference{" +
                "time=" + time +
                ", drivenRightLegVoltage=" + drivenRightLegVoltage +
                ", referenceVoltage=" + referenceVoltage +
                '}';
    }

    @Override
    protected DrlReference newInstance() {
        return new DrlReference();
    }

    @Override
    protected DrlReference update(DrlReference that) {
        this.time = that.time;
        this.drivenRightLegVoltage = that.drivenRightLegVoltage;
        this.referenceVoltage = that.referenceVoltage;
        return this;
    }
}
