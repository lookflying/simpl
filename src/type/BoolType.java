package type;

public class BoolType extends Type {
	private static BoolType instance = new BoolType();
	
	public static BoolType getInstance() {
		return instance;
	}

	@Override
	public boolean equals(Type other) {
		return null != other && ((this == other) || other instanceof BoolType);
	}
}
