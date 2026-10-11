;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 928)
(include sci.sh)
(use Main)
(use Print)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(class RTRandCycle of RandCycle
	(properties
		sel_20 {RTRandCycle}
	)

	(method (sel_57 &tmp temp0)
		(if (or (> sel_467 (= temp0 (GetTime))) (== sel_467 -1))
			(if (> (- temp0 sel_158) (sel_42 sel_244:))
				(sel_42 sel_4: (self sel_241:))
				(= sel_158 (GetTime))
			)
		else
			(sel_42 sel_4: 0)
			(self sel_242:)
		)
	)

	(method (sel_110 param1 param2 param3)
		(super sel_110: param1)
		(sel_42 sel_4: 0)
		(= sel_158 (GetTime))
		(if (>= argc 2)
			(if (!= param2 -1)
				(= sel_467 (+ (GetTime) param2))
			else
				(= sel_467 -1)
			)
			(if (>= argc 3)
				(= sel_143 param3)
			)
		else
			(= sel_467 -1)
		)
	)
)

(class Blink of Cycle
	(properties
		sel_20 {Blink}
		sel_533 0
		sel_534 0
		sel_535 0
		sel_536 0
	)

	(method (sel_110 param1 param2)
		(if argc
			(= sel_535 (/ param2 2))
			(= sel_536 (+ param2 sel_535))
			(super sel_110: param1)
		else
			(super sel_110:)
		)
	)

	(method (sel_57 &tmp temp0)
		(cond
			(sel_533
				(if (> (- gGameTime sel_533) 0)
					(= sel_533 0)
					(self sel_110:)
				)
			)
			((or (> (= temp0 (self sel_241:)) (sel_42 sel_246:)) (< temp0 0))
				(= sel_239 (- sel_239))
				(self sel_242:)
			)
			(else
				(sel_42 sel_4: temp0)
			)
		)
	)

	(method (sel_242)
		(if (== sel_239 -1)
			(self sel_110:)
		else
			(= sel_533 (+ (Random sel_535 sel_536) gGameTime))
		)
	)
)

(class Narrator of Prop
	(properties
		sel_20 {Narrator}
		sel_1 -1
		sel_0 -1
		sel_143 0
		sel_291 1
		sel_139 0
		sel_537 0
		sel_538 0
		sel_203 0
		sel_30 0
		sel_539 0
		sel_407 0
		sel_540 0
		sel_25 0
		sel_26 7
		sel_541 0
		sel_204 0
	)

	(method (sel_110)
		(if global83
			(self sel_541: (gGame sel_404:))
			(if (>= (gGame sel_404:) 4)
				(gGame sel_404: (- sel_541 4))
			)
			(if (not sel_203)
				(= sel_204 (gGame sel_197: gWaitCursor 1))
			)
		)
		(= sel_407 1)
	)

	(method (sel_295 param1 param2 param3 param4 param5 param6 &tmp [temp0 4])
		(gTheIconBar sel_233:)
		(if (and (> argc 5) param6)
			(= sel_214 param6)
		else
			(= sel_214 -1)
		)
		(if (not sel_407)
			(self sel_110:)
		)
		(if (== sel_214 -1)
			(= sel_214 gCurRoomNum)
		)
		(= sel_143 (if (and (> argc 4) param5) param5 else 0))
		(if (& gMsgType $0002)
			(self sel_544:)
		)
		(if (& gMsgType $0001)
			(self sel_542:)
		)
		(cond
			(sel_203
				(gMouseDownHandler sel_129: self)
				(gKeyDownHandler sel_129: self)
				(gTheDoits sel_118: self)
			)
			((IsObject gFastCast)
				(gFastCast sel_118: self)
			)
			(else
				((= gFastCast (EventHandler sel_109:))
					sel_20: {fastCast}
					sel_118: self
				)
			)
		)
		(+= sel_139 (+ 60 gGameTime))
		(return 1)
	)

	(method (sel_542 &tmp [temp0 1000] temp1000)
		(Message msgNEXT @temp0)
		(if (not (& gMsgType $0002))
			(= sel_139 (Max 240 (* 8 (= temp1000 (StrLen @temp0)))))
		)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(self sel_543: @temp0)
		(return temp1000)
	)

	(method (sel_543 param1 &tmp temp0 temp1)
		(if (> (+ sel_1 sel_537) 318)
			(= temp0 (- 318 sel_1))
		else
			(= temp0 sel_537)
		)
		((= temp1 (gSystemWindow sel_109:)) sel_25: sel_25 sel_26: sel_26)
		(if (and (not (HaveMouse)) (!= gTheCursor 996))
			(= sel_204 gTheCursor)
			(gGame sel_197: 996)
		else
			(= sel_204 0)
		)
		(Print
			sel_32: temp1
			sel_153: sel_1 sel_0
			sel_30: sel_30
			sel_67: temp0
			sel_77: (if sel_540 sel_20 else 0)
			sel_198: param1
			sel_203: 1
			sel_110:
		)
	)

	(method (sel_544))

	(method (sel_57)
		(if
			(and
				(!= sel_139 -1)
				(> (- gGameTime sel_139) 0)
				(if global83
					(== (DoAudio audPOSITION) -1)
				else
					1
				)
				(not sel_538)
			)
			(self sel_111: sel_291)
			(return 0)
		)
		(return 1)
	)

	(method (sel_133 param1)
		(cond
			((param1 sel_73:))
			((== sel_139 -1)
				(return 0)
			)
			(else
				(switch (param1 sel_31:)
					(256
						(= sel_539 0)
					)
					(1
						(= sel_539 (& (param1 sel_61:) $0003))
					)
					(4
						(= sel_539 (== (param1 sel_37:) 27))
					)
				)
				(if
					(or
						(& (param1 sel_31:) $4101)
						(and
							(& (param1 sel_31:) $0004)
							(OneOf (param1 sel_37:) 13 27)
						)
					)
					(param1 sel_73: 1)
					(self sel_111: sel_291)
				)
			)
		)
	)

	(method (sel_111 param1)
		(= sel_139 -1)
		(if (or (not argc) param1)
			(cond
				(sel_203
					(gKeyDownHandler sel_81: self)
					(gMouseDownHandler sel_81: self)
					(gTheDoits sel_81: self)
				)
				((and gFastCast (gFastCast sel_122: self))
					(gFastCast sel_81: self)
					(if (gFastCast sel_123:)
						(gFastCast sel_111:)
						(= gFastCast 0)
					)
				)
			)
			(if global83
				(DoAudio audSTOP)
			)
			(= sel_214 -1)
			(= sel_407 0)
		)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(if global83
			(gGame sel_404: sel_541)
		)
		(if (and sel_204 (not (HaveMouse)))
			(gGame sel_197: sel_204)
		)
		(if sel_143
			(sel_143 sel_145: sel_539)
		)
		(DisposeClone self)
	)
)

(class Talker of Narrator
	(properties
		sel_20 {Talker}
		sel_537 318
		sel_545 0
		sel_546 0
		sel_547 0
		sel_548 0
		sel_549 0
		sel_550 0
		sel_551 0
		sel_552 100
	)

	(method (sel_110 param1 param2 param3)
		(if argc
			(= sel_545 param1)
			(if (>= argc 2)
				(= sel_546 param2)
				(if (>= argc 3)
					(= sel_547 param3)
				)
			)
		)
		(self sel_180:)
		(super sel_110:)
	)

	(method (sel_180)
		(= sel_7 sel_1)
		(= sel_6 sel_0)
		(= sel_9
			(+
				sel_7
				(Max
					(if sel_2
						(CelWide sel_2 sel_3 sel_4)
					else
						0
					)
					(and
						(IsObject sel_545)
						(+
							(sel_545 sel_7:)
							(CelWide
								(sel_545 sel_2:)
								(sel_545 sel_3:)
								(sel_545 sel_4:)
							)
						)
					)
					(and
						(IsObject sel_546)
						(+
							(sel_546 sel_7:)
							(CelWide
								(sel_546 sel_2:)
								(sel_546 sel_3:)
								(sel_546 sel_4:)
							)
						)
					)
					(and
						(IsObject sel_547)
						(+
							(sel_547 sel_7:)
							(CelWide
								(sel_547 sel_2:)
								(sel_547 sel_3:)
								(sel_547 sel_4:)
							)
						)
					)
				)
			)
		)
		(= sel_8
			(+
				sel_6
				(Max
					(if sel_2
						(CelHigh sel_2 sel_3 sel_4)
					else
						0
					)
					(and
						(IsObject sel_545)
						(+
							(sel_545 sel_6:)
							(CelHigh
								(sel_545 sel_2:)
								(sel_545 sel_3:)
								(sel_545 sel_4:)
							)
						)
					)
					(and
						(IsObject sel_546)
						(+
							(sel_546 sel_6:)
							(CelHigh
								(sel_546 sel_2:)
								(sel_546 sel_3:)
								(sel_546 sel_4:)
							)
						)
					)
					(and
						(IsObject sel_547)
						(+
							(sel_547 sel_6:)
							(CelHigh
								(sel_547 sel_2:)
								(sel_547 sel_3:)
								(sel_547 sel_4:)
							)
						)
					)
				)
			)
		)
	)

	(method (sel_216 &tmp temp0)
		(if (not sel_5)
			(= sel_5 (Graph grSAVE_BOX sel_6 sel_7 sel_8 sel_9 1))
		)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(if sel_545
			(DrawCel
				(sel_545 sel_2:)
				(sel_545 sel_3:)
				(sel_545 sel_4:)
				(+ (sel_545 sel_7:) sel_7)
				(+ (sel_545 sel_6:) sel_6)
				-1
			)
		)
		(if sel_546
			(DrawCel
				(sel_546 sel_2:)
				(sel_546 sel_3:)
				(sel_546 sel_4:)
				(+ (sel_546 sel_7:) sel_7)
				(+ (sel_546 sel_6:) sel_6)
				-1
			)
		)
		(if sel_547
			(DrawCel
				(sel_547 sel_2:)
				(sel_547 sel_3:)
				(sel_547 sel_4:)
				(+ (sel_547 sel_7:) sel_7)
				(+ (sel_547 sel_6:) sel_6)
				-1
			)
		)
		(DrawCel sel_2 sel_3 sel_4 sel_7 sel_6 -1)
		(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
		(PicNotValid temp0)
	)

	(method (sel_295)
		(if (or (== sel_214 -1) (and (> sel_2 0) (not sel_5)))
			(self sel_110:)
			(if (== sel_214 -1)
				(= sel_214 gCurRoomNum)
			)
		)
		(super sel_295: &rest)
	)

	(method (sel_542 &tmp temp0)
		(if (not sel_548)
			(self sel_216:)
		)
		(= temp0 (super sel_542: &rest))
		(if sel_547
			(sel_547 sel_161: RTRandCycle (* 4 temp0))
		)
		(if (and sel_546 (not (sel_546 sel_245:)))
			(sel_546 sel_161: Blink sel_552)
		)
	)

	(method (sel_543 param1 &tmp temp0 temp1 temp2 temp3)
		((= temp3 (gSystemWindow sel_109:)) sel_25: sel_25 sel_26: sel_26)
		(if (and (not (HaveMouse)) (!= gTheCursor 996))
			(= sel_204 gTheCursor)
			(gGame sel_197: 996)
		else
			(= sel_204 0)
		)
		(if sel_548
			(= temp0
				(if sel_551
					sel_3
				else
					(sel_545 sel_3:)
				)
			)
			(Print
				sel_32: temp3
				sel_153: sel_1 sel_0
				sel_203: 1
				sel_30: sel_30
				sel_67: temp1
				sel_77: (if sel_540 sel_20 else 0)
				sel_198: param1
				sel_206: sel_2 temp0 sel_4 0 0
				sel_110:
			)
		else
			(if (not (+ sel_549 sel_550))
				(= sel_549 (+ (- sel_9 sel_7) 5))
			)
			(if (> (+ (= temp2 (+ sel_7 sel_549)) sel_537) 318)
				(= temp1 (- 318 temp2))
			else
				(= temp1 sel_537)
			)
			(Print
				sel_32: temp3
				sel_153: (+ sel_1 sel_549) (+ sel_0 sel_550)
				sel_203: 1
				sel_30: sel_30
				sel_67: temp1
				sel_77: (if sel_540 sel_20 else 0)
				sel_198: param1
				sel_110:
			)
		)
	)

	(method (sel_544 param1)
		(self sel_216:)
		(super sel_544: param1 &rest)
		(if (and sel_546 (not (sel_546 sel_245:)))
			(sel_546 sel_161: Blink sel_552)
		)
	)

	(method (sel_186 param1 &tmp temp0 [temp1 100])
		(if (and param1 (param1 sel_245:))
			(= temp0 (param1 sel_4:))
			((param1 sel_245:) sel_57:)
			(if (!= temp0 (param1 sel_4:))
				(DrawCel
					(param1 sel_2:)
					(param1 sel_3:)
					(param1 sel_4:)
					(+ (param1 sel_7:) sel_7)
					(+ (param1 sel_6:) sel_6)
					-1
				)
				(param1
					sel_9:
						(+
							(param1 sel_7:)
							(CelWide
								(param1 sel_2:)
								(param1 sel_3:)
								(param1 sel_4:)
							)
						)
				)
				(param1
					sel_8:
						(+
							(param1 sel_6:)
							(CelHigh
								(param1 sel_2:)
								(param1 sel_3:)
								(param1 sel_4:)
							)
						)
				)
				(Graph
					grUPDATE_BOX
					(+ (param1 sel_6:) sel_6)
					(+ (param1 sel_7:) sel_7)
					(+ (param1 sel_8:) sel_6)
					(+ (param1 sel_9:) sel_7)
					1
				)
			)
		)
	)

	(method (sel_57)
		(if (and (super sel_57:) sel_547)
			(self sel_186: sel_547)
		)
		(if sel_546
			(self sel_186: sel_546)
		)
	)

	(method (sel_102)
		(Graph grRESTORE_BOX sel_5)
		(= sel_5 0)
		(Graph grREDRAW_BOX sel_6 sel_7 sel_8 sel_9)
		(gTheIconBar sel_177:)
	)

	(method (sel_111 param1)
		(if (and sel_547 sel_5)
			(sel_547 sel_4: 0)
			(DrawCel
				(sel_547 sel_2:)
				(sel_547 sel_3:)
				0
				(+ (sel_547 sel_7:) sel_7)
				(+ (sel_547 sel_6:) sel_6)
				-1
			)
		)
		(if (and sel_547 (sel_547 sel_245:))
			(if ((sel_547 sel_245:) sel_116: 145)
				((sel_547 sel_245:) sel_145:)
			)
			(sel_547 sel_161: 0)
		)
		(if (or (not argc) param1)
			(if (and sel_546 sel_5)
				(sel_546 sel_161: 0 sel_4: 0)
				(DrawCel
					(sel_546 sel_2:)
					(sel_546 sel_3:)
					0
					(+ (sel_546 sel_7:) sel_7)
					(+ (sel_546 sel_6:) sel_6)
					-1
				)
			)
			(self sel_102:)
		)
		(super sel_111: param1)
	)
)
