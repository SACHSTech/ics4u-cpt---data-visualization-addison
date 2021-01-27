package cpt;

public class province {
    private int intyear;
    private String strprovince;
    private String typerate;
    private double rates;

    public province(String[] provincedata){
        this.intyear = Integer.parseInt(provincedata[0]);
        this.strprovince =provincedata[1];
        this.typerate = (provincedata[2]);
        this.rates= Double.parseDouble(provincedata[3]);
        }
        public int getyear(){
            return this.intyear;
        }
        public String getprovince(){
            return this.strprovince;
        }
        public String gettyperate(){
            return this.typerate;
        }
        public double getrates(){
            return this.rates;
        }
}
