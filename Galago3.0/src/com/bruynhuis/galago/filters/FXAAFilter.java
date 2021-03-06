/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruynhuis.galago.filters;

import com.jme3.asset.AssetManager;
import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.material.Material;
import com.jme3.math.Vector2f;
import com.jme3.post.Filter;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import java.io.IOException;

/**
 *
 * @author NideBruyn
 */
public class FXAAFilter extends Filter {

    /*
     * This is the point on screen between 0 and 1 that starts the shackwave
     */
    private Vector2f resolution = new Vector2f(600, 400);

    /**
     * creates a ShockwaveFilter
     */
    public FXAAFilter() {
        super("FXAAFilter");

    }

    @Override
    protected Material getMaterial() {
        material.setVector2("Resolution", resolution);
        return material;
    }

    public Vector2f getResolution() {
        return resolution;
    }

    /**
     * This is the point on screen between 0 and 1 that starts the shackwave
     * @param distortionPoint 
     */
    public void setResolution(Vector2f resolution) {
        this.resolution = resolution;
        if (material != null) {
            material.setVector2("Resolution", resolution);
        }
    }

    @Override
    protected void initFilter(AssetManager manager, RenderManager renderManager, ViewPort vp, int w, int h) {
        resolution = new Vector2f(w, h);
        material = new Material(manager, "Resources/filters/fxaa.j3md");
    }

    @Override
    public void write(JmeExporter ex) throws IOException {
        super.write(ex);
        OutputCapsule oc = ex.getCapsule(this);
//        oc.write(distortionOffsets, "distortionOffsets", Vector3f.ZERO);
    }

    @Override
    public void read(JmeImporter im) throws IOException {
        super.read(im);
        InputCapsule ic = im.getCapsule(this);
//        distortionOffsets = (Vector3f) ic.readSavable("distortionOffsets", Vector3f.ZERO);
    }
}
