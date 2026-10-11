;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 255)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	StillDown 0
	GetNumber 1
	MousedOn 2
)

(procedure (StillDown &tmp event ret)
	(= ret (!= ((= event (Event sel_109:)) sel_31:) 2))
	(event sel_111:)
	(return ret)
)

(procedure (GetNumber string default &tmp [theLine 40]) ; UNUSED
	(= theLine 0)
	(if (> argc 1)
		(Format @theLine {%d} default)
	)
	(return
		(if (GetInput @theLine 5 string)
			(ReadNumber @theLine)
		else
			-1
		)
	)
)

(procedure (MousedOn obj event) ; UNUSED
	(return
		(if
			(and
				(< (obj sel_7:) (event sel_1:))
				(< (event sel_1:) (obj sel_9:))
				(< (obj sel_6:) (event sel_0:))
			)
			(< (event sel_0:) (obj sel_8:))
		else
			0
		)
	)
)

(class DItem of Obj
	(properties
		sel_20 0
		sel_31 0
		sel_29 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_21 0
		sel_72 0
		sel_74 0
	)

	(method (sel_57)
		(return sel_74)
	)

	(method (sel_177 param1)
		(if param1
			(|= sel_29 $0001)
		else
			(&= sel_29 $fffe)
		)
	)

	(method (sel_178 param1)
		(if param1
			(|= sel_29 $0008)
		else
			(&= sel_29 $fff7)
		)
		(self sel_80:)
	)

	(method (sel_133 param1 &tmp temp0 temp1 temp2)
		(if (param1 sel_73:)
			(return 0)
		)
		(= temp0 0)
		(if
			(and
				(& sel_29 $0001)
				(or
					(and (== (= temp1 (param1 sel_31:)) 128) (Said sel_72))
					(and (== temp1 4) (== (param1 sel_37:) sel_21))
					(and (== temp1 1) (self sel_174: param1))
				)
			)
			(param1 sel_73: 1)
			(= temp0 (self sel_179: param1))
		)
		(return temp0)
	)

	(method (sel_174 param1)
		(return
			(if
				(and
					(>= (param1 sel_1:) sel_7)
					(>= (param1 sel_0:) sel_6)
					(< (param1 sel_1:) sel_9)
				)
				(< (param1 sel_0:) sel_8)
			else
				0
			)
		)
	)

	(method (sel_179 param1 &tmp temp0 temp1)
		(if (== 1 (param1 sel_31:))
			(= temp1 0)
			(while 1
				((= param1 (Event sel_109: -32768)) sel_148:)
				(if (!= (= temp0 (self sel_174: param1)) temp1)
					(HiliteControl self)
					(= temp1 temp0)
				)
				(param1 sel_111:)
				(if (not (StillDown))
					(break)
				)
			)
			(if temp0
				(HiliteControl self)
			)
			(return temp0)
		else
			(return self)
		)
	)

	(method (sel_180))

	(method (sel_181 param1 param2)
		(+= sel_9 param1)
		(+= sel_7 param1)
		(+= sel_6 param2)
		(+= sel_8 param2)
	)

	(method (sel_182 param1 param2)
		(self sel_181: (- param1 sel_7) (- param2 sel_6))
	)

	(method (sel_80)
		(DrawControl self)
	)

	(method (sel_184 param1)
		(return (== sel_31 param1))
	)

	(method (sel_185 param1)
		(return (& sel_29 param1))
	)

	(method (sel_186))
)

(class DText of DItem
	(properties
		sel_20 {DText}
		sel_31 2
		sel_23 0
		sel_30 1
		sel_27 0
	)

	(method (sel_109 &tmp temp0)
		((super sel_109:) sel_30: gUserFont sel_117:)
	)

	(method (sel_111 param1)
		(if (and sel_23 (or (not argc) (not param1)))
			(Memory memFREE (self sel_23:))
		)
		(super sel_111:)
	)

	(method (sel_180 param1 &tmp [temp0 2] temp2 temp3)
		(TextSize
			@temp0
			sel_23
			sel_30
			(if argc param1 else 0)
			{ \n---------- \n}
		)
		(= sel_8 (+ sel_6 temp2))
		(= sel_9 (+ sel_7 temp3))
	)
)

(class Dialog of List
	(properties
		sel_20 {Dialog}
		sel_23 0
		sel_30 0
		sel_32 0
		sel_187 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_22 0
		sel_143 0
		sel_137 0
		sel_138 0
		sel_188 0
		sel_140 0
	)

	(method (sel_57 param1 &tmp temp0 temp1 temp2)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= temp2 0)
		(self sel_119: 110)
		(if sel_187
			(sel_187 sel_178: 0)
		)
		(= sel_187
			(if (and argc param1)
				param1
			else
				(self sel_120: 185 1)
			)
		)
		(if sel_187
			(sel_187 sel_178: 1)
		)
		(if (not sel_187)
			(= sel_188 gEatMice)
			(= sel_140 (GetTime))
		else
			(= sel_188 0)
		)
		(= temp1 0)
		(while (not temp1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(self sel_119: 186)
			(= temp0 ((Event sel_109:) sel_148:))
			(if sel_188
				(-- sel_188)
				(if (== (temp0 sel_31:) 1)
					(temp0 sel_31: 0)
				)
				(while (== sel_140 (GetTime))
				)
				(= sel_140 (GetTime))
			)
			(= temp1 (self sel_133: temp0))
			(temp0 sel_111:)
			(if (self sel_174:)
				(break)
			)
			(if (== temp1 -2)
				(= temp1 0)
				(EditControl sel_187 0)
				(break)
			)
			(Wait 1)
		)
		(return temp1)
	)

	(method (sel_111 &tmp temp0)
		(self sel_119: 111 sel_125:)
		(if (== self gModelessDialog)
			(SetPort gModelessPort)
			(= gModelessDialog 0)
			(= gModelessPort 0)
		)
		(if sel_32
			(sel_32 sel_111:)
			(= sel_32 0)
		)
		(= sel_187 0)
		(= temp0 sel_143)
		(super sel_111:)
		(if temp0
			(temp0 sel_145:)
		)
	)

	(method (sel_189 param1 param2)
		(if (and (PicNotValid) gCast)
			(Animate (gCast sel_24:) 0)
		)
		(= sel_32 (sel_32 sel_109:))
		(sel_32
			sel_193: sel_6
			sel_194: sel_7
			sel_195: sel_8
			sel_196: sel_9
			sel_77: sel_23
			sel_31: param1
			sel_60: param2
			sel_189:
		)
		(= sel_137 sel_22)
		(self sel_80:)
	)

	(method (sel_80)
		(self sel_119: 80)
	)

	(method (sel_190 &tmp temp0 temp1)
		(if sel_187
			(sel_187 sel_178: 0)
			(= temp1 (self sel_122: sel_187))
			(while 1
				(if (not (= temp1 (self sel_65: temp1)))
					(= temp1 (self sel_124:))
				)
				(= sel_187 (NodeValue temp1))
				(if (& (sel_187 sel_29:) $0001)
					(break)
				)
			)
			(sel_187 sel_178: 1)
			(gGame
				sel_197:
					gTheCursor
					1
					(+
						(sel_187 sel_7:)
						(/ (- (sel_187 sel_9:) (sel_187 sel_7:)) 2)
					)
					(- (sel_187 sel_8:) 3)
			)
		)
	)

	(method (sel_191 &tmp temp0 temp1)
		(if sel_187
			(sel_187 sel_178: 0)
			(= temp1 (self sel_122: sel_187))
			(while 1
				(if (not (= temp1 (self sel_128: temp1)))
					(= temp1 (self sel_127:))
				)
				(= sel_187 (NodeValue temp1))
				(if (& (sel_187 sel_29:) $0001)
					(break)
				)
			)
			(sel_187 sel_178: 1)
			(gGame
				sel_197:
					gTheCursor
					1
					(+
						(sel_187 sel_7:)
						(/ (- (sel_187 sel_9:) (sel_187 sel_7:)) 2)
					)
					(- (sel_187 sel_8:) 3)
			)
		)
	)

	(method (sel_181 param1 param2)
		(+= sel_9 param1)
		(+= sel_7 param1)
		(+= sel_6 param2)
		(+= sel_8 param2)
	)

	(method (sel_182 param1 param2)
		(self sel_181: (- param1 sel_7) (- param2 sel_6))
	)

	(method (sel_192)
		(self
			sel_182:
				(+
					(sel_32 sel_17:)
					(/
						(-
							(- (sel_32 sel_19:) (sel_32 sel_17:))
							(- sel_9 sel_7)
						)
						2
					)
				)
				(+
					(sel_32 sel_16:)
					(/
						(-
							(- (sel_32 sel_18:) (sel_32 sel_16:))
							(- sel_8 sel_6)
						)
						2
					)
				)
		)
	)

	(method (sel_180 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if sel_23
			(TextSize @temp2 sel_23 sel_30 -1 0)
			(= sel_6 temp2)
			(= sel_7 temp3)
			(= sel_8 temp4)
			(= sel_9 temp5)
		else
			(= sel_9 (= sel_8 (= sel_7 (= sel_6 0))))
		)
		(for ((= temp0 (self sel_124:))) temp0 ((= temp0 (self sel_65: temp0)))
			(if (< ((= temp1 (NodeValue temp0)) sel_7:) sel_7)
				(= sel_7 (temp1 sel_7:))
			)
			(if (< (temp1 sel_6:) sel_6)
				(= sel_6 (temp1 sel_6:))
			)
			(if (> (temp1 sel_9:) sel_9)
				(= sel_9 (temp1 sel_9:))
			)
			(if (> (temp1 sel_8:) sel_8)
				(= sel_8 (temp1 sel_8:))
			)
		)
		(+= sel_9 4)
		(+= sel_8 4)
		(self sel_182: 0 0)
	)

	(method (sel_133 param1 &tmp temp0 temp1 temp2)
		(if (& (param1 sel_31:) $0040)
			(switch (param1 sel_37:)
				(5
					(param1 sel_31: 4 sel_37: 20480)
				)
				(1
					(param1 sel_31: 4 sel_37: 18432)
				)
				(7
					(param1 sel_31: 4 sel_37: 19200)
				)
				(3
					(param1 sel_31: 4 sel_37: 19712)
				)
			)
		)
		(= temp1 (param1 sel_31:))
		(= temp2 (param1 sel_37:))
		(if (= temp0 (self sel_120: 133 param1))
			(EditControl sel_187 0)
			(if (not (temp0 sel_185: 2))
				(if sel_187
					(sel_187 sel_178: 0)
				)
				((= sel_187 temp0) sel_178: 1)
				(temp0 sel_57:)
				(= temp0 0)
			else
				(return temp0)
			)
		else
			(= temp0 0)
			(cond
				(
					(and
						(or (== temp1 256) (and (== temp1 4) (== temp2 13)))
						sel_187
						(sel_187 sel_185: 1)
					)
					(= temp0 sel_187)
					(EditControl sel_187 0)
					(param1 sel_73: 1)
				)
				((and (== temp1 4) (== temp2 27))
					(param1 sel_73: 1)
					(= temp0 -1)
				)
				(
					(and
						(not (self sel_120: 185 1))
						(or
							(and (== temp1 4) (== temp2 13))
							(OneOf temp1 1 256)
						)
					)
					(param1 sel_73: 1)
					(= temp0 -2)
				)
				(
					(and
						(IsObject sel_187)
						(sel_187 sel_184: 3)
						(== temp1 4)
						(== temp2 19712)
					)
					(if (>= (sel_187 sel_33:) (StrLen (sel_187 sel_23:)))
						(self sel_190:)
					else
						(EditControl sel_187 param1)
					)
				)
				(
					(and
						(IsObject sel_187)
						(sel_187 sel_184: 3)
						(== temp1 4)
						(== temp2 19200)
					)
					(if (<= (sel_187 sel_33:) 0)
						(self sel_191:)
					else
						(EditControl sel_187 param1)
					)
				)
				((and (== temp1 4) (OneOf temp2 9 19712 20480))
					(param1 sel_73: 1)
					(self sel_190:)
				)
				((and (== temp1 4) (OneOf temp2 3840 19200 18432))
					(param1 sel_73: 1)
					(self sel_191:)
				)
				(else
					(EditControl sel_187 param1)
				)
			)
		)
		(return temp0)
	)

	(method (sel_174 &tmp temp0)
		(if (and sel_137 (!= sel_138 (= temp0 (GetTime 1)))) ; SysTime12
			(= sel_138 temp0)
			(return (not (-- sel_137)))
		else
			0
		)
	)
)
