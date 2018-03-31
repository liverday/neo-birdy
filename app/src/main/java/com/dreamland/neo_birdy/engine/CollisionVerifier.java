package com.dreamland.neo_birdy.engine;

import com.dreamland.neo_birdy.element.Bird;
import com.dreamland.neo_birdy.element.Pipes;

public class CollisionVerifier {
    private final Pipes pipes;
    private final Bird bird;
    public CollisionVerifier(Bird bird, Pipes pipes) {
        this.bird = bird;
        this.pipes = pipes;
    }

    public boolean hasCollided() {
        return pipes.hasCollidedWith(bird);
    }
}
