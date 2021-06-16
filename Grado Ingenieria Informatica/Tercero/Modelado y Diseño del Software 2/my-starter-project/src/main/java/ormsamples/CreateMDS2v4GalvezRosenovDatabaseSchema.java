/**
 * Licensee: Maria(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateMDS2v4GalvezRosenovDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(basedatos.MDS2v4GalvezRosenovPersistentManager.instance());
			basedatos.MDS2v4GalvezRosenovPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
