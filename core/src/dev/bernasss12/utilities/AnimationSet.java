package dev.bernasss12.utilities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import dev.bernasss12.model.EnumActorFacing;

import java.util.HashMap;
import java.util.Map;

public class AnimationSet {

    private Map<EnumActorFacing, Animation> walking;
    private Map<EnumActorFacing, TextureRegion> standing;

    public AnimationSet(Animation walkingNorth,
                        Animation walkingSouth,
                        Animation walkingEast,
                        Animation walkingWest,
                        TextureRegion standingNorth,
                        TextureRegion standingSouth,
                        TextureRegion standingEast,
                        TextureRegion standingWest){
        walking = new HashMap<EnumActorFacing, Animation>();
        walking.put(EnumActorFacing.N, walkingNorth);
        walking.put(EnumActorFacing.S, walkingSouth);
        walking.put(EnumActorFacing.E, walkingEast);
        walking.put(EnumActorFacing.W, walkingWest);
        standing = new HashMap<EnumActorFacing, TextureRegion>();
        standing.put(EnumActorFacing.N, standingNorth);
        standing.put(EnumActorFacing.S, standingSouth);
        standing.put(EnumActorFacing.E, standingEast);
        standing.put(EnumActorFacing.W, standingWest);
    }

    public Animation<TextureRegion> getWalking(EnumActorFacing dir){
        return walking.get(dir);
    }

    public TextureRegion getStanding(EnumActorFacing dir){
        return standing.get(dir);
    }

}
