;;; Sierra Script 1.0 - (do not remove this comment)
(script# 925)
(include sci.sh)
(use Main)
(use Print)
(use Obj)


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
			(gLb2Messager
				sel_297:
					(Message
						msgGET
						sel_214
						sel_213
						sel_553
						sel_554
						(if sel_555 else 1)
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
			(= global4 1)
		else
			(if sel_30 (sel_556 sel_30: sel_30))
			(if (or sel_1 sel_0)
				(sel_556 sel_1: sel_1 sel_0: sel_0)
			)
			(gLb2Messager
				sel_295: sel_213 sel_553 sel_554 sel_555 sel_143 sel_214
			)
		)
	)
)

(class Conversation of List
	(properties
		sel_20 {Conversation}
		sel_24 0
		sel_86 0
		sel_142 0
		sel_557 -1
		sel_143 0
	)
	
	(method (sel_110 theSel_143)
		(= sel_557 -1)
		(if (and argc (IsObject theSel_143))
			(= sel_143 theSel_143)
		)
		(gTheDoits sel_118: self)
		(self sel_145:)
	)
	
	(method (sel_57)
		(if sel_142 (sel_142 sel_57:))
	)
	
	(method (sel_111 &tmp theSel_143)
		(self sel_119: 96 cleanCode)
		(gTheDoits sel_81: self)
		(if gSel_201 (gSel_201 sel_111:))
		(if sel_142 (= sel_142 0))
		(= theSel_143 sel_143)
		(super sel_111:)
		(if theSel_143 (theSel_143 sel_145:))
	)
	
	(method (sel_118 theTheGSel_40 &tmp theGSel_40 theTheTheGSel_40 theTheTheGSel_40_2 theTheTheGSel_40_3 theTheTheGSel_40_4 theTheTheGSel_40_5 theTheTheGSel_40_6 theTheTheGSel_40_7)
		(= theGSel_40
			(= theTheTheGSel_40
				(= theTheTheGSel_40_2
					(= theTheTheGSel_40_3 (= theTheTheGSel_40_4 0))
				)
			)
		)
		(= theTheTheGSel_40_5
			(= theTheTheGSel_40_6 (= theTheTheGSel_40_7 0))
		)
		(if (and argc (not (IsObject [theTheGSel_40 0])))
			(if (== (= theGSel_40 [theTheGSel_40 0]) -1)
				(= theGSel_40 gSel_40)
			)
			(if (> argc 1)
				(= theTheTheGSel_40 [theTheGSel_40 1])
				(if (> argc 2)
					(= theTheTheGSel_40_2 [theTheGSel_40 2])
					(if (> argc 3)
						(= theTheTheGSel_40_3 [theTheGSel_40 3])
						(if (> argc 4)
							(= theTheTheGSel_40_4 [theTheGSel_40 4])
							(if (> argc 5)
								(= theTheTheGSel_40_5 [theTheGSel_40 5])
								(if (> argc 6)
									(= theTheTheGSel_40_6 [theTheGSel_40 6])
									(if (> argc 7) (= theTheTheGSel_40_7 [theTheGSel_40 7]))
								)
							)
						)
					)
				)
			)
			(if (not (IsObject [theTheGSel_40 0]))
				(super
					sel_118:
						((MessageObj sel_109:)
							sel_214: theGSel_40
							sel_213: theTheTheGSel_40
							sel_553: theTheTheGSel_40_2
							sel_554: theTheTheGSel_40_3
							sel_555: theTheTheGSel_40_4
							sel_1: theTheTheGSel_40_5
							sel_0: theTheTheGSel_40_6
							sel_30: theTheTheGSel_40_7
							sel_117:
						)
				)
			)
		else
			(super sel_118: theTheGSel_40 &rest)
		)
	)
	
	(method (sel_145 param1 &tmp temp0 temp1)
		(if
		(or (and argc param1) (== (++ sel_557) sel_86))
			(self sel_111:)
		else
			(= temp0 (self sel_64: sel_557))
			(cond 
				((temp0 sel_114: MessageObj) (temp0 sel_143: self sel_113:))
				((temp0 sel_114: Script) (self sel_146: temp0 self))
				((IsObject temp0) (temp0 sel_57: self))
				(else (self sel_145:))
			)
		)
	)
	
	(method (sel_146 param1)
		(if (IsObject sel_142) (sel_142 sel_111:))
		(if param1 (param1 sel_110: self &rest))
	)
	
	(method (sel_558 param1 &tmp theGSel_40 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= theGSel_40 (proc999_6 param1 0))
		(= temp1 (proc999_6 param1 1))
		(= temp2 (proc999_6 param1 2))
		(= temp3 (proc999_6 param1 3))
		(= temp4 (proc999_6 param1 4))
		(= temp5 (proc999_6 param1 5))
		(= temp6 (proc999_6 param1 6))
		(= temp7 (proc999_6 param1 7))
		(= temp8 7)
		(while theGSel_40
			(if (== theGSel_40 -1) (= theGSel_40 gSel_40))
			(self
				sel_118: theGSel_40 temp1 temp2 temp3 temp4 temp5 temp6 temp7
			)
			(= theGSel_40 (proc999_6 param1 (++ temp8)))
			(= temp1 (proc999_6 param1 (++ temp8)))
			(= temp2 (proc999_6 param1 (++ temp8)))
			(= temp3 (proc999_6 param1 (++ temp8)))
			(= temp4 (proc999_6 param1 (++ temp8)))
			(= temp5 (proc999_6 param1 (++ temp8)))
			(= temp6 (proc999_6 param1 (++ temp8)))
			(= temp7 (proc999_6 param1 (++ temp8)))
		)
	)
)

(instance cleanCode of Code
	(properties
		sel_20 {cleanCode}
	)
	
	(method (sel_57 param1 &tmp temp0)
		(if (param1 sel_114: Script) (param1 sel_143: 0))
		(if
			(and
				(param1 sel_114: MessageObj)
				(IsObject (= temp0 (param1 sel_556?)))
				(temp0 sel_5?)
			)
			(temp0 sel_111: 1)
		)
	)
)
