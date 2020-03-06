package job.written.examination;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class CloneTest implements Cloneable{
    private Date date;
    private Integer nums;
    private String str;

    @Override
    public CloneTest clone() throws CloneNotSupportedException {
        CloneTest cloneTest = (CloneTest)super.clone();
        cloneTest.setDate(new Date(date.getTime()));
        cloneTest.setNums(new Integer(nums));
        cloneTest.setStr(new String(str));
        return cloneTest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloneTest cloneTest = (CloneTest) o;
        return Objects.equals(date, cloneTest.date) &&
                Objects.equals(nums, cloneTest.nums) &&
                Objects.equals(str, cloneTest.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, nums, str);
    }
}
