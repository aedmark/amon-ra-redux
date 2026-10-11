;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm18 0
)

(local
	local0
	local1
	local2
	local3 = 25
	[local4 25] = [0 1 1 2 3 4 5 5 5 6 6 6 7 7 7 7 8 8 8 9 9 10 10 10 11]
	local29 = 1
)

(instance tempList of List
	(properties
		sel_20 {tempList}
	)
)

(instance goodList of List
	(properties
		sel_20 {goodList}
	)
)

(instance rm18 of LBRoom
	(properties
		sel_20 {rm18}
		sel_408 18
	)

	(method (sel_110 &tmp temp0 temp1 temp2 temp3)
		(LoadMany rsVIEW 18)
		(super sel_110:)
		(gGame sel_588:)
		(gTheIconBar sel_233: 0 1 3 4 5 6 7)
		(goodList sel_118:)
		(tempList sel_118:)
		(= temp2 -32)
		(= temp3 46)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(tempList sel_118: ((egyptProp sel_109:) sel_4: temp0 sel_117:))
		)
		(while (tempList sel_86:)
			(= temp0 (Random 0 (- (tempList sel_86:) 1)))
			(= temp1 (tempList sel_64: temp0))
			(goodList
				sel_118: (temp1 sel_1: (+= temp2 48) sel_0: temp3 sel_117:)
			)
			(if (== (goodList sel_86:) 6)
				(= temp2 -32)
				(= temp3 111)
			)
			(tempList sel_81: temp1)
		)
		(gGame sel_587:)
		(self sel_146: sInitEm)
	)

	(method (sel_111)
		(goodList sel_125: sel_111:)
		(tempList sel_125: sel_111:)
		(super sel_111:)
	)

	(method (sel_133)
		(return 0)
	)
)

(instance sInitEm of Script
	(properties
		sel_20 {sInitEm}
	)

	(method (sel_144 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(= sel_137 2)
			)
			(1
				((goodList sel_120: 96 checkCel sel_141)
					sel_110:
					sel_146: sFlipIt self sel_141
				)
			)
			(2
				(if (< (++ sel_141) (goodList sel_86:))
					(= sel_29 0)
					(= sel_136 1)
				else
					(= sel_65 sAskIt)
					(self sel_111:)
				)
			)
		)
	)
)

(instance sFlipIt of Script
	(properties
		sel_20 {sFlipIt}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= local0 (sel_42 sel_4:))
				(sel_42 sel_3: 1 sel_4: 0)
				(sel_42 sel_161: End self)
			)
			(1
				(gGameMusic2 sel_40: 55 sel_99: 1 sel_3: 1 sel_39:)
				(sel_42 sel_3: 0 sel_4: local0 sel_317:)
				(if (== sel_141 11)
					(gGame sel_588: 1)
				)
				(self sel_111:)
			)
		)
	)
)

(instance sAskIt of Script
	(properties
		sel_20 {sAskIt}
	)

	(method (sel_144 param1 &tmp [temp0 50])
		(switch (= sel_29 param1)
			(0
				(= sel_136 1)
			)
			(1
				(if
					(or
						(== (= local1 (Random 1 local3)) global146)
						(== local1 global147)
					)
					(-- sel_29)
					(self sel_145:)
				else
					(switch gAct
						(1
							(= global146 local1)
							(= local2 230)
						)
						(3
							(= global147 local1)
							(= local2 355)
						)
						(5
							(= local2 420)
						)
					)
				)
				(= sel_137 2)
			)
			(2
				(Message msgGET 18 2 0 0 local1 @temp0)
				(Display @temp0 dsCOORD 15 15 dsFONT 61 dsWIDTH 280 dsALIGN alCENTER dsCOLOR global151)
				(Display @temp0 dsCOORD 15 15 dsFONT 60 dsWIDTH 280 dsALIGN alCENTER dsCOLOR 23)
			)
			(3
				(if local29
					(SetFlag 34)
				else
					(ClearFlag 34)
				)
				(gCurRoom sel_399: local2)
			)
		)
	)
)

(instance egyptProp of Prop
	(properties
		sel_20 {egyptProp}
		sel_2 18
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(== sel_4 [local4 (- local1 1)])
				(sAskIt sel_145:)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance checkCel of Code
	(properties
		sel_20 {checkCel}
	)

	(method (sel_57 param1 param2)
		(return (== (param1 sel_4:) param2))
	)
)
