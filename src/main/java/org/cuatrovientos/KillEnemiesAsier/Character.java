package org.cuatrovientos.KillEnemiesAsier;

import java.io.Serializable;
//Hacemos que Character extienda de Serializable para convertir el estado de un
//objeto en memoria a un flujo de bytes para guardarlo en un archvio o enviarlo por la red
public interface Character extends Serializable{
	boolean isEnemy();
}
