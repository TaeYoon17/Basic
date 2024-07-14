import kotlin.reflect.KProperty

// 리플렉션을 사용해 T 내부의 타입이 무엇을 가지는지 확인한다.
// KClass - 코틀린 클래스 정의
// 클래스::class - 인스턴스::class
fun <T:Any>stringify(target: T):String{
//    target::class.members.filter { it is KProperty<*> }.forEach {  }
    val builder = StringBuilder()
    builder.append("{")
    // 멤버들을 순회하며 원하는 타입을 만족하는 것만 남기기 - property: 클래스의 저장 프로퍼티, 계산 프로퍼티
    target::class.members.filterIsInstance<KProperty<*>>().forEach {
        builder.append(it.name,':') // KProperty.name - 속성명
        val value = it.getter.call(target)
        builder.append(value,',')
    }
    builder.append("}")
    return "$builder"
}
// 고정 컬렉션 - Mutable Collection이 있음
// Iterator - Array, Sequence -> 대부분의 기능이 Iterator 내부에 있음 사용하는 방법이 List, Set, Map 거의 유사함

class Json0(val a:Int, val b: String)
