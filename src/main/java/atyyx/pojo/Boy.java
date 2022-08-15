package atyyx.pojo;

import java.util.Objects;

/**
 * @author yyx
 * @version 1.0
 * @data 2022/8/10 16:06
 */
public class Boy {
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boy)) return false;
        Boy boy = (Boy) o;
        return getGirl().equals(boy.getGirl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGirl());
    }
}
