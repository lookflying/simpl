package type;

public class UnitType extends Type {
	private static UnitType instance = new UnitType();
	
	public static UnitType getInstance() {
		return instance;
	}

	@Override
	public boolean equals(Type other) {
		return null != other && ((this == other) || other instanceof UnitType);
	}
}
