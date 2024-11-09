package basic.animal;

import basic.animal.animalinterface.Ageable;
import basic.animal.animalinterface.Appearance;
import basic.animal.animalinterface.Habitat;
import basic.animal.animalinterface.Movable;
import basic.animal.animalinterface.Nameable;
import basic.animal.animalinterface.Soundable;
import basic.animal.animalinterface.Species;

public interface AnimalInterface extends Appearance, Habitat, Movable, Nameable, Soundable, Species, Ageable {

}
