package xdp.test.guava.base;

import com.google.common.base.MoreObjects;

public class FOO {
	
    public String sortedBy;
    
    public int notSortedBy;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("sortedBy", sortedBy).add("notSortedBy", notSortedBy).toString();
	}
    
}
