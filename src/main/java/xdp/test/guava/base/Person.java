package xdp.test.guava.base;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Person {
	
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	public Person(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper("MyPerson").add("id", id).add("name", name).add("age", age).toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id,name,age);
	}

	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return Objects.equal(id, p.id) && Objects.equal(name, p.name) && Objects.equal(age, p.age);
	}

	
	
}
