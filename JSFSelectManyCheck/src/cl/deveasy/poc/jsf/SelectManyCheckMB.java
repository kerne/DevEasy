package cl.deveasy.poc.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import cl.deveasy.poc.to.Persona;

@ManagedBean(name = "manyCheck")
@ViewScoped
public class SelectManyCheckMB {

	private List<Persona> list = new ArrayList<Persona>();
	private List<Integer> check = new ArrayList<Integer>();

	{

		list.add(new Persona(1, "Cesar", "Araya"));
		list.add(new Persona(2, "Daisy", "Araya"));

	}

	public void selected(ValueChangeEvent event) {

		String[] selected = (String[]) event.getNewValue();

		for (int i = 0; i < selected.length; i++) {
			check.add(Integer.valueOf(selected[i]));
		}
	}

	public void deleted() {

		for (Integer it : check) {
			for (int i = 0; i < list.size(); i++) {
				if (it == list.get(i).getId()) {
					list.remove(list.get(i));
				}
			}
		}

	}

	/**
	 * @return the list
	 */
	public List<Persona> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Persona> list) {
		this.list = list;
	}

	public List<Integer> getCheck() {
		return check;
	}

}
