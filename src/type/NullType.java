package type;

public class NullType extends Type {
	
	private static NullType instance = new NullType();
	
	public static NullType getInstance() {
		return instance;
	}

	@Override
	public boolean equals(Type other) {
		return null != other && ((this == other) || other instanceof NullType);
	}

	@Override
	public String getName() {
		return "?";
	}
}
