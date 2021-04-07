public class Report {
    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public void addReport(String report) {
        this.report += report;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    String report = "";
    double totalCharge = 0;
    int totalPoint = 0;

    public void addCharge(double eachCharge) {
        totalCharge += eachCharge;
    }

    public void addPoint(int eachPoint) {
        totalPoint += eachPoint;
    }
}
