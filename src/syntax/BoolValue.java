package syntax;

public class BoolValue extends Value {
	boolean value;

	public BoolValue(Boolean b) {
		value = b;
	}

	public String toString() {
		if (value)
			return "true";
		else
			return "false";
	}
}