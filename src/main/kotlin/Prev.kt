/*
target::class.members.filterIsInstance<KProperty<*>>().forEach {
    builder.append(it.name,':') // KProperty.name - 속성명
    val value = it.getter.call(target)
    builder.append(value,',')
}
builder.append("}")
이 코드의 출력
{a:3,b:abc,} => {"a":3,"b":"abc"} 가 되어야 함
 */