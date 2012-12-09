class Tupel {
	private final Number value;
	private final int count;

	public Tupel(Number value, int count) {
		this.value = value;
		this.count = count;
	}

	Tupel addIntValue(Tupel t) {
		return new Tupel(value.intValue() + t.value.intValue(), 
				count + t.count);
	}

	Tupel addFloatValue(Tupel t) {
		return new Tupel(value.floatValue() + t.value.floatValue(),
				count + t.count);
	}

	int intValue() {
    	return value.intValue();
	}

	float floatValue() {
    	return value.floatValue();
	}

	int getCount() {
		return count;
	}
}
