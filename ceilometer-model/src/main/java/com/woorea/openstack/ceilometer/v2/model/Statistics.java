package com.woorea.openstack.ceilometer.v2.model;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * To know the statistics of meter in Ceilometer model.
 * @author Krishna <krishna.it2329@gmail.com>
 */
public class Statistics {

    /**
     * Every Statistics of Ceilometer average is known. Since average may be
     * larger in size so we use BigDecimel.
     */
    private BigDecimal avg;

    /**
     * In statistics for every event count is recorded.
     */
    private BigDecimal count;

    /**
     * Every event duration is noted and time is calculated.
     */
    private BigDecimal duration;

    /**
     * The event is started durationStart is started to record the event
     * occurrence.
     */
    @JsonProperty("duration_start")
    private String durationStart;

    /**
     * After the overall duration is over durationEnd is invoked.
     */
    @JsonProperty("duration_end")
    private String durationEnd;

    /**
     * The maximum statistics occurred is noted by declaring it in BigDecimel.
     */
    private BigDecimal max;

    /**
     * The minimum statistics occurred is noted by declaring it in BigDecimel.
     */
    private BigDecimal min;

    /**
     * Every time interval the statistics is noted in period.
     */
    private BigDecimal period;

    /**
     * To start the event interval period periodStart is invoked.
     */
    @JsonProperty("period_start")
    private String periodStart;

    /**
     * To end the event interval period periodEnd is invoked.
     */
    @JsonProperty("period_end")
    private String periodEnd;

    /**
     * For every average time period sum is calculated.
     */
    private BigDecimal sum;

    /**
     * To get the average statistics getAvg method is defined.
     * @return statistics average in BigDecimal format.
     */
    public BigDecimal getAvg() {
        return avg;
    }

    /**
     * To get every count of statistics in an event getCount method is defined.
     * @return statistics count in BigDecimal format.
     */
    public BigDecimal getCount() {
        return count;
    }

    /**
     * For the overall Duration getDuration method in invoked.
     * @return statistics duration in BigDecimal format.
     */
    public BigDecimal getDuration() {
        return duration;
    }

    /**
     * To start the duration for statistics getDuartionStart method is defined.
     * @return statistics durationStart in BigDecimal format.
     */
    public String getDurationStart() {
        return durationStart;
    }

    /**
     * To end the duration for statistics getDurationEnd method is defined.
     * @return statistics duartionEnd in BigDecimal format.
     */
    public String getDurationEnd() {
        return durationEnd;
    }

    /**
     * To get the maximum statistics in the meter getMax method is defined.
     * @return statistics max in BigDecimal format.
     */
    public BigDecimal getMax() {
        return max;
    }

    /**
     * To get the minimum statistics in the meter getMin method is defined.
     * @return statistics min in BigDecimal format.
     */
    public BigDecimal getMin() {
        return min;
    }

    /**
     * To know every time interval statistics getPeriod method is defined.
     * @return statistics period in BigDecimal format.
     */
    public BigDecimal getPeriod() {
        return period;
    }

    /**
     * To start the time interval of an event in statistics getPeriodStart
     * method is defined.
     * @return statistics periodStart in BigDecimal format.
     */
    public String getPeriodStart() {
        return periodStart;
    }

    /**
     * To end the time interval of an event in statistics getPeriodEnd is
     * invoked.
     * @return statistics periodEnd in BigDecimel format.
     */
    public String getPeriodEnd() {
        return periodEnd;
    }

    /**
     * Total sum of the statistics is obtained by getSum method.
     * @return statistics sum in BigDecimal format.
     */
    public BigDecimal getSum() {
        return sum;
    }
    
    /**
     * This method gives information about all the specified details of
     * Statistics components.
     * @return all the Statistics components in Ceilometer model.
     */
    @Override
    public String toString() {
        return "Statistics [avg=" + avg + ", count=" + count + ", duration="
                + duration + ", durationStart=" + durationStart
                + ", durationEnd=" + durationEnd + ", max=" + max + ", min="
                + min + ", period=" + period + ", periodStart=" + periodStart
                + ", periodEnd=" + periodEnd + ", sum=" + sum + "]";
    }
}
