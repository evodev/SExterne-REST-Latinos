package business;

public class ActeAuthentique {

    private int ordre_num;
    private String date;
    private int minutaire_num;
    private int minute_num;
    private String designation;
    private String signature;

    public ActeAuthentique() {
    }

    public int getOrdreNum() {
        return ordre_num;
    }

    public void setOrdreNum(int ordre_num){
        this.ordre_num = ordre_num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMinutaireNum() {
        return minutaire_num;
    }

    public void setMinutaireNum(int minutaire_num) {
        this.minutaire_num = minutaire_num;
    }

    public int getMinuteNum() {
        return minute_num;
    }

    public void setMinuteNum(int minute_num) {
        this.minute_num = minute_num;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
