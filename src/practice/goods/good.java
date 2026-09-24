package practice.goods;

public class good {
    private int id;
    private String name ;
    private int price ;
    private  int kucun ;


    public good() {
    }

    public good(int id, String name, int price, int kucun) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kucun = kucun;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 获取
     * @return kucun
     */
    public int getKucun() {
        return kucun;
    }

    /**
     * 设置
     * @param kucun
     */
    public void setKucun(int kucun) {
        this.kucun = kucun;
    }
}

