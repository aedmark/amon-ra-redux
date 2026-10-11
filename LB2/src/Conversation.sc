;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 925)
(include sci.sh)
(use Main)
(use Print)
(use System)

(class MessageObj of Obj
	(properties
		sel_20 {MessageObj}
		sel_214 -1
		sel_213 0
		sel_553 0
		sel_554 0
		sel_555 0
		sel_556 0
		sel_42 0
		sel_143 0
		sel_30 0
		sel_1 0
		sel_0 0
	)

	(method (sel_113 &tmp [temp0 40])
		(= sel_556
			(gMessager
				sel_297:
					(Message
						msgGET
						sel_214
						sel_213
						sel_553
						sel_554
						(if sel_555 sel_555 else 1)
					)
			)
		)
		(if (not (IsObject sel_556))
			(Print
				sel_199:
					@temp0
					{<MessageObj> Message not found: %d - %d, %d, %d, %d}
					sel_214
					sel_213
					sel_553
					sel_554
					sel_555
				sel_110:
			)
			(= gQuit 1)
		else
			(if sel_30
				(sel_556 sel_30: sel_30)
			)
			(if (or sel_1 sel_0)
				(sel_556 sel_1: sel_1 sel_0: sel_0)
			)
			(gMessager sel_295: sel_213 sel_553 sel_554 sel_555 sel_143 sel_214)
		)
	)
)

(class Conversation of List
	(properties
		sel_20 {Conversation}
		sel_142 0
		sel_557 -1
		sel_143 0
	)

	(method (sel_110 param1)
		(= sel_557 -1)
		(if (and argc (IsObject param1))
			(= sel_143 param1)
		)
		(gTheDoits sel_118: self)
		(self sel_145:)
	)

	(method (sel_57)
		(if sel_142
			(sel_142 sel_57:)
		)
	)

	(method (sel_111 &tmp temp0)
		(self sel_119: 96 cleanCode)
		(gTheDoits sel_81: self)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(if sel_142
			(= sel_142 0)
		)
		(= temp0 sel_143)
		(super sel_111:)
		(if temp0
			(temp0 sel_145:)
		)
	)

	(method (sel_118 param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 0)))))
		(= temp5 (= temp6 (= temp7 0)))
		(if (and argc (not (IsObject param1)))
			(if (== (= temp0 param1) -1)
				(= temp0 gCurRoomNum)
			)
			(if (> argc 1)
				(= temp1 param2)
				(if (> argc 2)
					(= temp2 param3)
					(if (> argc 3)
						(= temp3 param4)
						(if (> argc 4)
							(= temp4 param5)
							(if (> argc 5)
								(= temp5 param6)
								(if (> argc 6)
									(= temp6 param7)
									(if (> argc 7)
										(= temp7 param8)
									)
								)
							)
						)
					)
				)
			)
			(if (not (IsObject param1))
				(super
					sel_118:
						((MessageObj sel_109:)
							sel_214: temp0
							sel_213: temp1
							sel_553: temp2
							sel_554: temp3
							sel_555: temp4
							sel_1: temp5
							sel_0: temp6
							sel_30: temp7
							sel_117:
						)
				)
			)
		else
			(super sel_118: param1 &rest)
		)
	)

	(method (sel_145 param1 &tmp temp0 temp1)
		(if (or (and argc param1) (== (++ sel_557) sel_86))
			(self sel_111:)
		else
			(= temp0 (self sel_64: sel_557))
			(cond
				((temp0 sel_114: MessageObj)
					(temp0 sel_143: self sel_113:)
				)
				((temp0 sel_114: Script)
					(self sel_146: temp0 self)
				)
				((IsObject temp0)
					(temp0 sel_57: self)
				)
				(else
					(self sel_145:)
				)
			)
		)
	)

	(method (sel_146 param1)
		(if (IsObject sel_142)
			(sel_142 sel_111:)
		)
		(if param1
			(param1 sel_110: self &rest)
		)
	)

	(method (sel_558 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp0 (WordAt param1 0))
		(= temp1 (WordAt param1 1))
		(= temp2 (WordAt param1 2))
		(= temp3 (WordAt param1 3))
		(= temp4 (WordAt param1 4))
		(= temp5 (WordAt param1 5))
		(= temp6 (WordAt param1 6))
		(= temp7 (WordAt param1 7))
		(= temp8 7)
		(while temp0
			(if (== temp0 -1)
				(= temp0 gCurRoomNum)
			)
			(self sel_118: temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
			(= temp0 (WordAt param1 (++ temp8)))
			(= temp1 (WordAt param1 (++ temp8)))
			(= temp2 (WordAt param1 (++ temp8)))
			(= temp3 (WordAt param1 (++ temp8)))
			(= temp4 (WordAt param1 (++ temp8)))
			(= temp5 (WordAt param1 (++ temp8)))
			(= temp6 (WordAt param1 (++ temp8)))
			(= temp7 (WordAt param1 (++ temp8)))
		)
	)
)

(instance cleanCode of Code
	(properties
		sel_20 {cleanCode}
	)

	(method (sel_57 param1 &tmp temp0)
		(if (param1 sel_114: Script)
			(param1 sel_143: 0)
		)
		(if
			(and
				(param1 sel_114: MessageObj)
				(IsObject (= temp0 (param1 sel_556:)))
				(temp0 sel_5:)
			)
			(temp0 sel_111: 1)
		)
	)
)
