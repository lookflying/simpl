package type;

public class PairType extends Type {
	Type t1;
	Type t2;
	
	public PairType(Type t1, Type t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public boolean equals(Type other) {
		if (other == null || (other instanceof PairType) == false) {
			return false;
		}
		PairType otherPairType = (PairType)other;
		return t1.equals(otherPairType.t1) &&
				t2.equals(otherPairType.t2);
	}
}
