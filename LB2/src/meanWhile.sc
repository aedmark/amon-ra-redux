;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 521)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	meanWhile 0
)

(instance meanWhile of LBRoom
	(properties
		sel_20 {meanWhile}
	)

	(method (sel_110)
		(self sel_414: 90)
		(super sel_110: &rest)
		(self sel_146: sMeanWhile)
	)
)

(instance rosettaCloth of View
	(properties
		sel_20 {rosettaCloth}
		sel_1 223
		sel_0 105
		sel_2 521
		sel_3 13
		sel_60 9
		sel_14 16
	)
)

(instance snakeOil of View
	(properties
		sel_20 {snakeOil}
		sel_1 113
		sel_0 94
		sel_2 520
		sel_3 3
		sel_60 8
		sel_14 16
	)
)

(instance secretDoor of View
	(properties
		sel_20 {secretDoor}
		sel_1 294
		sel_0 159
		sel_2 524
		sel_3 1
	)
)

(instance sMeanWhile of Script
	(properties
		sel_20 {sMeanWhile}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gCurRoom sel_408: 780)
				(DrawPic 780 9)
				(gGame sel_587:)
				(= sel_136 2)
			)
			(1
				(DrawPic 780 11)
				(Display {Meanwhile...} dsCOORD 100 85 dsCOLOR 14 dsFONT 0)
				(= sel_137 5)
			)
			(2
				(DrawPic 780 11)
				(= sel_136 1)
			)
			(3
				(SetFlag 92)
				(gCurRoom sel_408: 520 sel_405: 520)
				(gCurRoom sel_408: 520)
				(DrawPic 520 9)
				(WrapMusic sel_168: 1)
				(gGameMusic2 sel_40: 520 sel_99: 1 sel_3: -1 sel_39:)
				(if (not (IsFlag 49))
					(rosettaCloth sel_110: sel_311: 4 1 8)
				)
				(if (not (IsFlag 48))
					(snakeOil sel_110: sel_311: 1 8)
				)
				(deadCountess sel_110: sel_317:)
				(secretDoor sel_110: sel_317:)
				(gEgo sel_102:)
				(olympia
					sel_110:
					sel_161: Walk
					sel_320: Scaler 140 90 190 0
					sel_312: MoveTo 161 163 self
				)
			)
			(4
				(olympia sel_161: StopWalk -1)
				(= sel_139 60)
			)
			(5
				(olympia sel_2: 523 sel_155: 4 sel_156: 0 sel_161: End self)
			)
			(6
				(gMessager sel_295: 55 0 1 1 self 520)
			)
			(7
				(olympia
					sel_2: 820
					sel_155: -1
					sel_161: Walk
					sel_312: MoveTo 181 120 self
				)
			)
			(8
				(olympia sel_161: StopWalk -1 sel_253: 270)
				(= sel_139 60)
			)
			(9
				(gMessager sel_295: 55 0 1 2 self 520)
			)
			(10
				(olympia sel_2: 523 sel_155: 5 sel_156: 0 sel_161: End self)
			)
			(11
				(= sel_139 60)
			)
			(12
				(gMessager sel_295: 55 0 4 0 self 520)
			)
			(13
				(olympia
					sel_2: 820
					sel_155: -1
					sel_161: Walk
					sel_312: MoveTo 170 250 self
				)
			)
			(14
				(olympia sel_111:)
				(gGameMusic2 sel_170: self)
				(= sel_137 10)
			)
			(15
				(if sel_137
					(= sel_137 0)
				)
				(WrapMusic sel_168: 0)
				(gCurRoom sel_399: gPrevRoomNum)
			)
		)
	)
)

(instance olympia of Actor
	(properties
		sel_20 {olympia}
		sel_1 170
		sel_0 250
		sel_2 820
		sel_3 2
		sel_60 13
		sel_14 16
	)
)

(instance deadCountess of View
	(properties
		sel_20 {deadCountess}
		sel_1 111
		sel_0 89
		sel_303 147
		sel_304 145
		sel_2 524
		sel_60 8
		sel_14 16400
	)
)
