package types

trait Middleware {
  def apply(data: DittoMap): DittoMap
}
