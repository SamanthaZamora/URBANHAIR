package co.urbanhair.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class Conexion<T> {

	private Class<T> c;
	private static EntityManager em = null;

	public Conexion() {
		em = Conexion.getEm();
	}

	public Conexion(Class<T> c) {
		em = Conexion.getEm();
		this.c = c;
	}

	public void setC(Class<T> c) {
		this.c = c;
	}

	public static EntityManager getEm() {
		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("URBANSS");
			em = emf.createEntityManager();
		}
		return em;
	}

	public static EntityManager getEmReset() {
		if (em != null) {
			// System.out.println("RESET");
			em.close();
			// System.out.println("CLOSE PERCITENCIA");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("URBANSS");
			em = emf.createEntityManager();
			// System.out.println("PERCITENCIA");
			// System.out.println("RESET COMPLETE");
		}
		return em;
	}

///////////////////////////////////////////////////////
// Method Abstract
///////////////////////////////////////////////////////
	/**
	 * Metodo que lista todos los datos de la tabla.
	 * 
	 * @return represeta la lista.
	 */

	public List<T> list() {
		return listLimit(true, -1, 1);
	}

	/**
	 * Metodo que permite consultar todos los reultados pero con un limite
	 * especifico.
	 */

	public List<T> listLimit(boolean all, int maxResults, int firstResul) {
		TypedQuery<T> query = getEm().createNamedQuery(c.getSimpleName() + ".findAll", c);
		if (!all) {
			query.setMaxResults(maxResults);
			query.setFirstResult(firstResul);
		}
		return query.getResultList();
	}

	/**
	 * Metodo que trae el elemento mediante su PK.
	 * 
	 * @param <E>, representa el tipo de dato.
	 * @param id,  representa la PK.
	 * @return el elemento generico E.
	 */

	public <E> T find(E id) {
		return (T) getEm().find(c, id);
	}

	/**
	 * Metodo que inserta un elemento a la tabla.
	 * 
	 * @param o representa el elemento a insertar.
	 */

	public void insert(T o) {
		try {
			getEm().getTransaction().begin();
			getEm().persist(o);
			getEm().getTransaction().commit();
		} catch (Exception e) {
		} finally {
			if (em != null) {
				em = getEmReset();
			}
		}
	}

	/**
	 * Metodo que actualiza un elemento de la tabla.
	 * 
	 * @param o representa el elemento a actualizar.
	 */

	public void update(T o) {
		try {
			getEm().getTransaction().begin();
			o = getEm().merge(o);
			getEm().getTransaction().commit();
		} catch (Exception e) {
		} finally {
			if (em != null) {
				em = getEmReset();
			}
		}
	}

	/**
	 * Metodo que elimina un elemento en la tabla.
	 * 
	 * @param o representa el elemento.
	 */

	public <E> void deleteById(E o) {
		try {
			getEm().getTransaction().begin();
			T model;
			try {
				model = find(o);
			} catch (EntityNotFoundException not) {
				throw new NonexistentEntityException("The " + c.getSimpleName() + " with pk " + o + " no exists.", not);
			}
			getEm().remove(model);
			getEm().getTransaction().commit();
		} catch (Exception e) {
		} finally {
			if (em != null) {
				em = getEmReset();
			}
		}
	}
	
	
	public void delete(T o) {
		try {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	/**
	 * Metodo que trae un elemento depediendo de un fila y su valor.
	 * 
	 * @param <E>     representa el valor.
	 * @param column, representa la columna.
	 * @param o,      representa el valor columna.
	 * @return el elemento encontrado.
	 */

	public <E> T findByField(String column, E o) {
		List<T> queryResult = findByFieldList(column, o);
		T returnObject = null;
		if (!queryResult.isEmpty()) {
			returnObject = queryResult.get(0);
		}
		return returnObject;
	}

	/**
	 * Metodo que lista los elementos depediendo de un columna y su valor.
	 * 
	 * @param <E>         representa el valor.
	 * @param fieldName,  representa la columna.
	 * @param fieldValue, representa el valor fila.
	 * @return la lista.
	 */

	public <E> List<T> findByFieldList(String column, E o) {
		CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(c);
		Root<T> root = criteriaQuery.from(c);
		criteriaQuery.select(root);

		@SuppressWarnings("unchecked")
		ParameterExpression<E> params = criteriaBuilder.parameter((Class<E>) Object.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get(column), params));

		TypedQuery<T> query = (TypedQuery<T>) getEm().createQuery(criteriaQuery);
		query.setParameter(params, (E) o);
		return query.getResultList();
	}

	/**
	 * Metodo que permite conocer la cantidad de registros en una tabla.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })

	public long count() {
		CriteriaQuery criteriaBuilder = getEm().getCriteriaBuilder().createQuery();
		Root<T> root = criteriaBuilder.from(c);
		criteriaBuilder.select(getEm().getCriteriaBuilder().count(root));
		TypedQuery<T> query = (TypedQuery<T>) getEm().createQuery(criteriaBuilder);
		return ((Long) query.getSingleResult()).intValue();
	}

}
