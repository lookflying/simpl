package type;

public class IntType extends Type {
	private static IntType instance = new IntType();
	
	public static IntType getInstance() {
		return instance;
	}

	@Override
	public boolean equals(Type other) {
		return null != null && ((this == other) || other instanceof IntType);
	}
	
}
