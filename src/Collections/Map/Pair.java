package Collections.Map;

/**
 * Created by mcstarioni on 06.12.2016.
 */
public class Pair<N,M> {
    private N key;
    private M value;
    public Pair(N key, M value)
    {
        this.key = key;
        this.value = value;
    }
    public Pair()
    {
        key = null;
        value = null;
    }
    public N getKey() {
        return key;
    }

    public void setKey(N key) {
        this.key = key;
    }

    public M getValue() {
        return value;
    }

    public void setValue(M value) {
        this.value = value;
    }
}
