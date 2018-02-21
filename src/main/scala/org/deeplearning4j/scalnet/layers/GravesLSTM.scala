package org.deeplearning4j.scalnet.layers

import org.deeplearning4j.nn.conf.distribution.Distribution
import org.deeplearning4j.nn.conf.weightnoise.IWeightNoise
import org.deeplearning4j.nn.conf.{ GradientNormalization, layers }
import org.deeplearning4j.nn.weights.WeightInit
import org.nd4j.linalg.activations.Activation
import org.nd4j.linalg.learning.config.IUpdater

class GravesLSTM(nIn: Int,
                 nOut: Int,
                 activation: Activation = Activation.IDENTITY,
                 forgetGateBiasInit: Double = 1.0,
                 gateActivation: Activation = Activation.SIGMOID,
                 weightInit: WeightInit = WeightInit.XAVIER,
                 biasInit: Double = Double.NaN,
                 dist: Distribution = null,
                 l1: Double = Double.NaN,
                 l2: Double = Double.NaN,
                 l1Bias: Double = Double.NaN,
                 l2Bias: Double = Double.NaN,
                 dropOut: Double = 0.0,
                 updater: IUpdater = null,
                 biasUpdater: IUpdater = null,
                 weightNoise: IWeightNoise = null,
                 gradientNormalization: GradientNormalization = GradientNormalization.None,
                 gradientNormalizationThreshold: Double = 1.0,
                 override val name: String = "")
    extends AbstractLSTM {

  override def compile: org.deeplearning4j.nn.conf.layers.Layer =
    new layers.GravesLSTM.Builder()
      .nIn(nIn)
      .nOut(nOut)
      .activation(activation)
      .forgetGateBiasInit(forgetGateBiasInit)
      .gateActivationFunction(gateActivation)
      .weightInit(weightInit)
      .biasInit(biasInit)
      .dist(dist)
      .l1(l1)
      .l2(l2)
      .l1Bias(l1Bias)
      .l2Bias(l2Bias)
      .dropOut(dropOut)
      .updater(updater)
      .biasUpdater(biasUpdater)
      .weightNoise(weightNoise)
      .gradientNormalization(gradientNormalization)
      .gradientNormalizationThreshold(gradientNormalizationThreshold)
      .name(name)
      .build()

  override def inputShape: List[Int] = List(nIn, nOut)

  override def outputShape: List[Int] = List(nOut, nIn)

}

object GravesLSTM {
  def apply(nIn: Int,
            nOut: Int,
            activation: Activation = Activation.IDENTITY,
            forgetGateBiasInit: Double = 1.0,
            gateActivationFn: Activation = Activation.SIGMOID,
            weightInit: WeightInit = WeightInit.XAVIER,
            biasInit: Double = Double.NaN,
            dist: Distribution = null,
            l1: Double = Double.NaN,
            l2: Double = Double.NaN,
            l1Bias: Double = Double.NaN,
            l2Bias: Double = Double.NaN,
            dropOut: Double = 0.0,
            updater: IUpdater = null,
            biasUpdater: IUpdater = null,
            weightNoise: IWeightNoise = null,
            gradientNormalization: GradientNormalization = GradientNormalization.None,
            gradientNormalizationThreshold: Double = 1.0): GravesLSTM =
    new GravesLSTM(
      nIn,
      nOut,
      activation,
      forgetGateBiasInit,
      gateActivationFn,
      weightInit,
      biasInit,
      dist,
      l1,
      l2,
      l1Bias,
      l2Bias,
      dropOut,
      updater,
      biasUpdater,
      weightNoise,
      gradientNormalization,
      gradientNormalizationThreshold
    )
}
