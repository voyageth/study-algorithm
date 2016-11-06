package sort;

import java.util.Comparator;

/**
 * @author voyageth
 *         2016-11-07
 */
public class MultiKeySort {
	public static class Employee {
		public Employee(String extension, String givenname, String surname) {
			this.extension = extension;
			this.givenname = givenname;
			this.surname = surname;
		}

		private String extension;
		private String givenname;
		private String surname;

		public String getExtension() {
			return extension;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}

		public String getGivenname() {
			return givenname;
		}

		public void setGivenname(String givenname) {
			this.givenname = givenname;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		@Override
		public String toString() {
			return String.format("extension:%s, givenname:%s, surname:%s", extension, givenname, surname);
		}
	}

	public static class StringAscComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if (o1 == null) {
				if (o2 == null) {
					return 0;
				} else {
					return 1;
				}
			} else {
				if (o2 == null) {
					return -1;
				} else {
					return o1.compareTo(o2);
				}
			}
		}
	}

	public static class EmployeeAscComparator implements Comparator<Employee> {
		private StringAscComparator stringAscComparator = new StringAscComparator();

		public int compare(Employee o1, Employee o2) {
			if (o1 == null) {
				if (o2 == null) {
					return 0;
				} else {
					return 1;
				}
			} else {
				if (o2 == null) {
					return -1;
				} else {
					int surnameComp = stringAscComparator.compare(o1.surname, o2.surname);
					if (surnameComp == 0) {
						return stringAscComparator.compare(o1.givenname, o2.givenname);
					} else {
						return surnameComp;
					}
				}
			}
		}
	}
}
