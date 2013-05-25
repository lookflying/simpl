package type;

public class FunType extends Type {
	Type srcType;
	Type dstType;
	
	public FunType(Type srcType, Type dstType) {
		super();
		this.srcType = srcType;
		this.dstType = dstType;
	}
	
	private static FunType instance = new FunType(NullType.getInstance(), NullType.getInstance());
	
	public static FunType getDummyInstance() {
		return instance;
	}

	@Override
	public boolean equals(Type other) {
		if (other == null || (other instanceof FunType) == false) {
			return false;
		}
		FunType otherFunType = (FunType)other;
		return srcType.equals(otherFunType.srcType) &&
				dstType.equals(otherFunType.dstType);
	}

	@Override
	public String getName() {
		return srcType.getName() + "->" + dstType.getName();
	}
}
