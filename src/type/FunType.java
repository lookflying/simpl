package type;

public class FunType extends Type {
	Type srcType;
	Type dstType;
	
	@Override
	public boolean equals(Type other) {
		if (other == null || (other instanceof FunType) == false) {
			return false;
		}
		FunType otherFunType = (FunType)other;
		return srcType.equals(otherFunType.srcType) &&
				dstType.equals(otherFunType.dstType);
	}
}
