package book.stack;


import java.util.Queue;

/**
 * 实现猫狗队列
 *
 * TODO 未验证
 */
public class Book004 {

    Queue<Pet> animalQue;
    Queue<Pet> dogQue;
    Queue<Pet> catQue;

    void add(Pet animal) {
        animalQue.offer(animal);
        if (animal instanceof Dog) {
            dogQue.offer(animal);
        } else {
            catQue.offer(animal);
        }
    }

    Pet pollAll() {
        Pet pet = animalQue.poll();
        if (pet instanceof Dog) {
            dogQue.poll();
        } else {
            catQue.poll();
        }
        return pet;
    }

    Pet pollDog() {
        if (dogQue.isEmpty()) {
            return null;
        }
        return getDog();
    }

    private Pet getDog() {
        Pet p = animalQue.poll();
        if (p instanceof Dog) {
            return p;
        }
        if (animalQue.isEmpty()) {
            return null;
        }
        Pet result = getDog();
        animalQue.offer(p);
        return result;
    }

}


class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet {

    public Dog(String type) {
        super("dog");
    }
}


class Cat extends Pet {

    public Cat(String type) {
        super("cat");
    }
}
