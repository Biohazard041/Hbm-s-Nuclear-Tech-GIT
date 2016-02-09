// Date: 25.12.2015 00:20:25
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.hbm.render;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ModelT45Helmet extends ModelBiped
{
  //fields
    ModelRenderer helmet;
  
  public ModelT45Helmet()
  {
    textureWidth = 64;
    textureHeight = 32;

      /*helmet = new ModelRenderer(this, 0, 0);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 8, 8, 8);
      Shape1.setRotationPoint(-4F, 0F - 8 + 0.0625F / 4, -4F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 32, 0);
      Shape2.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape2.setRotationPoint(1F, 1F - 8 + 0.0625F / 4 + 1, -5F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 40, 6);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape3.setRotationPoint(-5F, 1F - 8 + 0.0625F / 4, -5.466667F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 40, 0);
      Shape4.addBox(0F, 0F, 0F, 4, 2, 2);
      Shape4.setRotationPoint(-2F, 5F - 8 + 0.0625F / 4, -4F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, -0.7853982F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 54, 0);
      Shape5.addBox(0F, 2F, 0F, 2, 1, 2);
      Shape5.setRotationPoint(-1F, 5F - 8 + 0.0625F / 4, -4F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, -0.7853982F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 16);
      Shape6.addBox(0F, 0F, 0F, 10, 1, 9);
      Shape6.setRotationPoint(-5F, 6F - 8 + 0.0625F / 4, -4.5F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 32, 7);
      Shape7.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape7.setRotationPoint(-1.5F, 5F - 8 + 0.0625F / 4, -4.5F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, -0.7853982F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 32, 5);
      Shape8.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape8.setRotationPoint(0.5F, 5F - 8 + 0.0625F / 4, -4.5F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, -0.7853982F, 0F, 0F);*/
    
    	bipedHead = new ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4F, 0F - 8 + 0.0625F / 4, -4F, 8, 8, 8);
    	
    	bipedHead.setTextureOffset(32, 0);
    	bipedHead.addBox(1F, 1F - 8 + 0.0625F / 4 + 1, -5F, 2, 2, 1);
    	
    	bipedHead.setTextureOffset(40, 6);
    	bipedHead.addBox(-5F, 1F - 8 + 0.0625F / 4, -5.466667F, 1, 1, 4);
    	
    	bipedHead.setTextureOffset(0, 16);
    	bipedHead.addBox(-5F, 6F - 8 + 0.0625F / 4, -4.5F, 10, 1, 9);
    	
    	helmet = bipedHeadwear;
    	helmet.cubeList = new ArrayList();
    	
    	float yOffset = (float)Math.sqrt(2) * 3.5F;
    	float zOffset = - (float)Math.sqrt(2) * 0.5F;
    	
    	helmet.setTextureOffset(40, 0);
    	helmet.addBox(-2F, 5F - 8 + 0.0625F / 4 + yOffset, -4F + zOffset, 4, 2, 2);

    	helmet.setTextureOffset(54, 0);
    	helmet.addBox(-1F, 5F - 8 + 0.0625F / 4 + 2 + yOffset, -4F + zOffset, 2, 1, 2);

    	helmet.setTextureOffset(32, 7);
    	helmet.addBox(-1.5F, 5F - 8 + 0.0625F / 4 + 0.5F + yOffset, -4.5F + zOffset, 1, 1, 1);

    	helmet.setTextureOffset(32, 5);
    	helmet.addBox(0.5F, 5F - 8 + 0.0625F / 4 + 0.5F + yOffset, -4.5F + zOffset, 1, 1, 1);
  }
  
  /*public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
  }*/
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
	  EntityPlayer player = (EntityPlayer)entity;
	  if(player.isSneaking())
	  {
		  this.isSneak = true;
	  } else {
		  this.isSneak = false;
	  }
	  
    this.bipedHead.rotationPointX = 0.0F;
    this.bipedHead.rotationPointY = 0.0F;
    //this.helmet.rotationPointX = this.bipedHead.rotationPointX;
    //this.helmet.rotationPointY = this.bipedHead.rotationPointY;
    //this.helmet.rotateAngleY = this.bipedHead.rotateAngleY;
    //this.helmet.rotateAngleX = this.bipedHead.rotateAngleX;
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.helmet.rotationPointX = bipedHead.rotationPointX;
    this.helmet.rotationPointY = bipedHead.rotationPointY;
    this.helmet.rotateAngleX = bipedHead.rotateAngleX - 45;
  }
  
  @Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    GL11.glPushMatrix();
    GL11.glScalef(1.125F, 1.125F, 1.125F);
    GL11.glScalef(1.0625F, 1.0625F, 1.0625F);
    bipedHead.render(par7);
    helmet.render(par7);
    /*this.helmet.addChild(Shape1);
    this.helmet.addChild(Shape2);
    this.helmet.addChild(Shape3);
    this.helmet.addChild(Shape4);
    this.helmet.addChild(Shape5);
    this.helmet.addChild(Shape6);
    this.helmet.addChild(Shape7);
    this.helmet.addChild(Shape8);
    this.helmet.render(par7);*/
    GL11.glPopMatrix();
  }

}
