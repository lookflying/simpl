package type;

public class ListType extends Type {
	Type elementType;

	public ListType(Type elementType) {
		super();
		this.elementType = elementType;
	}

	@Override
	public boolean equals(Type other) {
		if (other == null || (other instanceof ListType) == false) {
			return false;
		}
		ListType otheListType = (ListType)other;
		return elementType.equals(otheListType.elementType);
	}
}
