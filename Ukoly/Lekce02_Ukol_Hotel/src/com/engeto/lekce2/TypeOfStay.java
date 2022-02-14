package com.engeto.lekce2;

public enum TypeOfStay {
        work ("work"),
        recreational ("recreational");

        private final String value;

        private TypeOfStay(final String value) {
            this.value = value;
        }

        public String getValue() { return value; }
}
