package dev.bernasss12.utilities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import dev.bernasss12.model.EnumFacing;

import java.util.HashMap;
import java.util.Map;

public class AnimationSet {

    private Map<EnumFacing, Animation> walking;
    private Map<EnumFacing, TextureRegion> standing;

    public AnimationSet(Animation walkingNorth,
                        Animation walkingSouth,
                        Animation walkingEast,
                        Animation walkingWest,
                        TextureRegion standingNorth,
                        TextureRegion standingSouth,
                        TextureRegion standingEast,
                        TextureRegion standingWest){
        walking = new HashMap<EnumFacing, Animation>();
        walking.put(EnumFacing.N, walkingNorth);
        walking.put(EnumFacing.S, walkingSouth);
        walking.put(EnumFacing.E, walkingEast);
        walking.put(EnumFacing.W, walkingWest);
        standing = new HashMap<EnumFacing, TextureRegion>();
        standing.put(EnumFacing.N, standingNorth);
        standing.put(EnumFacing.S, standingSouth);
        standing.put(EnumFacing.E, standingEast);
        standing.put(EnumFacing.W, standingWest);
    }

    public Animation<TextureRegion> getWalking(EnumFacing dir){
        return walking.get(dir);
    }

    public TextureRegion getStanding(EnumFacing dir){
        return standing.get(dir);
    }

}
