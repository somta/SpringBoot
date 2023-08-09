grammar Hello;

compilation_unit
    :
    prog+ EOF //EOF结束符号匹配
    ;

prog
    :
    level_num '9' HELLO ID '!'
    ;

level_num
    :
    NUM | '9'
    ;

//  '9' 是隐式词法，一般情况下，在词法解析树后，第一个排列（也就是当前位置） 匹配时首个匹配
// '9' 直接做本字符匹配

//词法解析 由这些组成
HELLO : H E L L O;

// 表示 由纯数字组成 最少有1个，可以有多个 至少出现一次
NUM : [0-9]+ ;

//表示 由数字和字母组成 最少有1个，可以有多个 至少出现一次
ID : [a-zA-Z0-9]+ ;

//如果是以这些符号开头的，这一行不匹配 放入 HIDDEN 隐藏通道
// 匹配双斜线后的任意字符，可以有可以没有
// .*? 非判断模式 可有可无
// '\r'? 可有可无  (适配linux)(liunx下的换行符为\n，win是\r\n)
LINE_COMMIT : '//' .*? '\r'? '\n' -> channel(HIDDEN);

//无效字符 跳过不匹配 放入隐藏通道
WS : [ \t\r\n]+ -> skip;

fragment H : [Hh];
fragment E : [Ee];
fragment L : [Ll];
fragment O : [Oo];