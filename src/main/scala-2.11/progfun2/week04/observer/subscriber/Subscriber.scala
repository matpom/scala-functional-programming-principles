package progfun2.week04.observer.subscriber

import progfun2.week04.observer.publisher.Publisher

trait Subscriber {
  def handler(pub: Publisher)
}