;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use Inset)
(use Conversation)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm550 0
	eastDoor 2
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm550 of LBRoom
	(properties
		sel_20 {rm550}
		sel_408 550
		sel_410 560
		sel_411 510
		sel_107 0
	)

	(method (sel_110)
		(LoadMany rsVIEW 550 552 553 554 831)
		(Load rsSCRIPT 956 939)
		(LoadMany rsSOUND 550 551 553 555 556 558)
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 110 0 190 0)
		(self sel_414: 90)
		(switch gPrevRoomNum
			(sel_411
				(gEgo sel_1: 160 sel_0: 250)
				(if (and (== gAct 3) (OneOf global111 4 5))
					(= local4 1)
					(embrace sel_110: sel_146: sEmbrace)
					(= local1 embrace)
				)
			)
			(sel_410
				(gEgo sel_349: 0 sel_253: 270)
			)
			(else
				(gGame sel_588:)
				(gEgo sel_153: 60 180)
			)
		)
		(super sel_110:)
		(eastDoor sel_110:)
		(if (IsFlag 97)
			(eastDoor sel_590: 1 sel_596: 1)
		)
		(if (IsFlag 5)
			(if (gCurRoom sel_259:)
				((gCurRoom sel_259:) sel_111:)
			)
			(gCurRoom
				sel_395:
					((Polygon sel_109:)
						sel_31: 2
						sel_110:
							0
							0
							319
							0
							319
							189
							236
							189
							210
							143
							252
							143
							248
							139
							279
							139
							279
							134
							244
							134
							233
							124
							226
							124
							223
							128
							162
							128
							156
							128
							147
							124
							97
							122
							33
							164
							0
							189
						sel_117:
					)
					((Polygon sel_109:)
						sel_31: 2
						sel_110:
							131
							125
							157
							131
							170
							139
							176
							151
							128
							160
							89
							160
							54
							156
							99
							125
						sel_117:
					)
					((Polygon sel_109:)
						sel_31: 2
						sel_110: 46 168 51 159 69 161 74 165 67 175 47 173
						sel_117:
					)
			)
			(chair sel_4: 1 sel_311: 4 1 8 sel_110: sel_313:)
			(typeWriter
				sel_4: 1
				sel_110:
				sel_311: 4 1 8
				sel_153: 123 158
				sel_317:
			)
			(deskLamp
				sel_156: 2
				sel_153: 57 172
				sel_311: 4 1 8
				sel_317:
				sel_110:
			)
			(wasteBasket sel_110: sel_4: 1 sel_313:)
			(hairs sel_110: sel_311: 4 1 8 sel_317:)
			(dressShred sel_110: sel_311: 4 1 8 sel_317:)
			(if (not (gEgo sel_238: 30))
				(shoe sel_110: sel_311: 4 1 8 sel_313:)
			)
			(paperCutter sel_311: 4 1 8 sel_110: sel_313:)
		else
			(if (or (> gAct 3) (and (== gAct 3) (TimeCheck $b102))) ; has 11:15 pm occurred?
				(paperCutter sel_311: 4 1 8 sel_110: sel_313:)
			else
				(paperCutter sel_155: 10 sel_311: 4 1 8 sel_110: sel_313:)
			)
			(chair sel_4: 0 sel_311: 4 1 8 sel_110: sel_313:)
			(typeWriter
				sel_4: 0
				sel_110:
				sel_311: 4 1 8
				sel_153: 100 126
				sel_317:
			)
			(if (IsFlag 40)
				(deskLamp sel_156: 0 sel_311: 4 1 8 sel_110: sel_317:)
			else
				(deskLamp sel_311: 4 1 8 sel_110: sel_317:)
			)
			(wasteBasket sel_110: sel_317: sel_311: 4 1 8 sel_313:)
		)
		(if (== gAct 4)
			(if (not (TimeCheck $2301)) ; has 2:45 am occurred?
				(yvette sel_110:)
				(paperCutter sel_146: sErnieDead)
			)
			(if (OneOf global111 12 13)
				(backRub sel_110: sel_161: Fwd)
				(= local1 backRub)
				(paperCutter sel_146: sBackRubViewing)
			)
		)
		(if (!= gPrevRoomNum 560)
			(WrapMusic sel_168: 1)
		)
		(if local4
			(gGameMusic2 sel_40: 551 sel_155: -1 sel_99: 1 sel_39:)
		else
			(gGameMusic2 sel_40: 550 sel_155: -1 sel_99: 1 sel_39:)
		)
		(southExitFeature sel_110:)
		(rug sel_110:)
		(desk sel_110:)
		(intercom sel_110:)
		(table sel_110:)
		(cutterBoard sel_110:)
		(floor sel_110:)
		(ceilingLamp sel_110:)
		(axes sel_110:)
		(needlepoint sel_110:)
		(plant sel_110:)
		(transom sel_110:)
		(diploma sel_110:)
		(pic1 sel_110:)
		(pic2 sel_110:)
		(pic3 sel_110:)
		(genericDrawer sel_110:)
		(if (IsFlag 40)
			(= local0 1)
		)
	)

	(method (sel_399 param1)
		(if (== param1 560)
			(gGameMusic2 sel_170:)
			(if
				(and
					(== gAct 3)
					(TimeCheck $c304 1) ; can 12:45 am occur?
					(not (TimeCheck $c304)) ; has 12:45 am occurred?
				)
				(= param1 565)
			)
		else
			(cond
				((OneOf global111 4 5)
					(= global111 6)
				)
				((OneOf global111 12 13)
					(= global111 14)
				)
			)
			(gGameMusic2 sel_170:)
		)
		(super sel_399: param1)
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

(instance eastDoor of Door
	(properties
		sel_20 {eastDoor}
		sel_1 248
		sel_0 83
		sel_213 36
		sel_301 40
		sel_303 234
		sel_304 135
		sel_2 550
		sel_3 1
		sel_60 4
		sel_14 16
		sel_589 560
		sel_597 267
		sel_598 135
		sel_599 0
		sel_600 0
	)

	(method (sel_145)
		(super sel_145:)
		(if (and (== sel_29 0) (== local1 embrace))
			(gGame sel_587:)
			(gCurRoom sel_146: sBackRubViewing)
		)
	)

	(method (sel_606)
		(super sel_606: 243 117 266 134 253 142 241 130)
	)
)

(instance paperCutter of Prop
	(properties
		sel_20 {paperCutter}
		sel_1 274
		sel_0 146
		sel_213 9
		sel_303 219
		sel_304 187
		sel_2 550
		sel_3 2
		sel_60 15
		sel_14 16
	)

	(method (sel_110)
		(if (IsFlag 88)
			(self sel_4: (self sel_246:))
		else
			(self sel_4: 0)
		)
		(super sel_110: &rest)
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(if (== sel_3 2)
					(gGame sel_87: 1 169)
					(gMessager sel_295: 9 1 5)
				else
					(gMessager sel_295: 9 1)
				)
			)
			(8
				(if (== sel_3 2)
					(gGame sel_87: 1 169)
					(gMessager sel_295: 9 8 5)
				else
					(gMessager sel_295: 9 8)
				)
			)
			(4
				(if (== sel_4 0)
					(SetFlag 88)
					(self sel_161: End self)
				else
					(ClearFlag 88)
					(self sel_161: Beg self)
				)
			)
			(else
				(super sel_300: param1 &rest)
			)
		)
	)

	(method (sel_145)
		(super sel_145: &rest)
		(self sel_313:)
		(if (== sel_3 2)
			(gGame sel_87: 1 169)
			(if (not (IsFlag 79))
				(SetFlag 79)
				(self sel_146: sOlympiaEnters)
			)
		)
	)
)

(instance embrace of Prop
	(properties
		sel_20 {embrace}
		sel_1 112
		sel_0 147
		sel_2 553
		sel_4 7
		sel_60 14
		sel_14 16
		sel_244 42
	)
)

(instance backRub of Prop
	(properties
		sel_20 {backRub}
		sel_1 135
		sel_0 150
		sel_2 553
		sel_3 2
		sel_60 14
		sel_14 16400
		sel_244 12
	)

	(method (sel_300 param1)
		(switch param1
			(0
				(self sel_146: sBackRubInterrupted)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance yvette of Prop
	(properties
		sel_20 {yvette}
		sel_1 130
		sel_0 146
		sel_2 554
		sel_3 1
		sel_4 12
		sel_60 14
		sel_14 16400
		sel_244 12
	)
)

(instance chair of View
	(properties
		sel_20 {chair}
		sel_1 137
		sel_0 149
		sel_213 3
		sel_303 174
		sel_304 157
		sel_2 550
		sel_3 8
		sel_4 1
		sel_60 11
		sel_14 16
	)
)

(instance typeWriter of View
	(properties
		sel_20 {typeWriter}
		sel_1 123
		sel_0 158
		sel_213 4
		sel_303 135
		sel_304 171
		sel_2 550
		sel_3 7
		sel_4 1
		sel_60 11
		sel_14 16400
	)
)

(instance deskLamp of View
	(properties
		sel_20 {deskLamp}
		sel_1 87
		sel_0 130
		sel_213 5
		sel_303 119
		sel_304 175
		sel_2 550
		sel_3 9
		sel_4 1
		sel_60 11
		sel_14 16400
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(if (== sel_4 2)
					(gMessager sel_295: sel_213 param1)
				else
					(gCurRoom sel_422: inDeskLamp)
				)
			)
			(8
				(if (== sel_4 2)
					(gMessager sel_295: sel_213 param1)
				else
					(gCurRoom sel_422: inDeskLamp)
				)
			)
			(4
				(self sel_300: 1)
			)
			(39
				(if (and (not (IsFlag 40)) (not (IsFlag 64)))
					(gCurRoom sel_146: sReadCarbonPaper)
				else
					(gMessager sel_295: sel_213 param1 6)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance wasteBasket of View
	(properties
		sel_20 {wasteBasket}
		sel_1 99
		sel_0 155
		sel_213 7
		sel_303 112
		sel_304 183
		sel_2 550
		sel_3 6
		sel_60 11
		sel_14 16400
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(if (and (not (gEgo sel_238: 29)) (not (IsFlag 170)))
					(gCurRoom sel_422: inCarbonPaper)
				else
					(super sel_300: param1 &rest)
				)
			)
			(4
				(if (and (not (gEgo sel_238: 29)) (not (IsFlag 170)))
					(gCurRoom sel_422: inCarbonPaper)
				else
					(super sel_300: param1 &rest)
				)
			)
			(8
				(if (and (not (gEgo sel_238: 29)) (not (IsFlag 170)))
					(gCurRoom sel_422: inCarbonPaper)
				else
					(super sel_300: param1 &rest)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance hairs of View
	(properties
		sel_20 {hairs}
		sel_1 98
		sel_0 126
		sel_213 38
		sel_303 104
		sel_304 188
		sel_2 550
		sel_3 3
		sel_4 1
	)

	(method (sel_110)
		(self sel_63: 11)
		(super sel_110: &rest)
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(gCurRoom sel_422: inHairs)
			)
			(8
				(gCurRoom sel_422: inHairs)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance dressShred of View
	(properties
		sel_20 {dressShred}
		sel_1 108
		sel_0 121
		sel_213 39
		sel_303 118
		sel_304 184
		sel_2 550
		sel_3 3
		sel_4 2
	)

	(method (sel_110)
		(self sel_63: 11)
		(super sel_110: &rest)
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(gCurRoom sel_422: inDressShred)
			)
			(8
				(gCurRoom sel_422: inDressShred)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance shoe of View
	(properties
		sel_20 {shoe}
		sel_1 83
		sel_0 124
		sel_213 37
		sel_303 90
		sel_304 186
		sel_2 550
		sel_3 3
	)

	(method (sel_110)
		(self sel_63: 11)
		(super sel_110: &rest)
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(gCurRoom sel_422: inShoe)
			)
			(8
				(gCurRoom sel_422: inShoe)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance rug of Feature
	(properties
		sel_20 {rug}
		sel_0 1
		sel_213 1
		sel_301 40
		sel_302 512
	)
)

(instance desk of Feature
	(properties
		sel_20 {desk}
		sel_0 1
		sel_213 2
		sel_301 40
		sel_302 1024
	)

	(method (sel_300 param1)
		(if (IsFlag 5)
			(switch param1
				(1
					(gMessager sel_295: sel_213 param1 8)
				)
				(4
					(gMessager sel_295: sel_213 param1 8)
				)
				(else
					(super sel_300: param1 &rest)
				)
			)
		else
			(super sel_300: param1 &rest)
		)
	)
)

(instance intercom of Feature
	(properties
		sel_20 {intercom}
		sel_0 1
		sel_213 6
		sel_301 40
		sel_302 4096
	)
)

(instance table of Feature
	(properties
		sel_20 {table}
		sel_0 1
		sel_213 8
		sel_301 40
		sel_302 256
	)
)

(instance cutterBoard of Feature
	(properties
		sel_20 {cutterBoard}
		sel_0 84
		sel_213 9
		sel_301 40
		sel_302 128
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_0 1
		sel_213 10
		sel_301 40
		sel_302 64
	)
)

(instance ceilingLamp of Feature
	(properties
		sel_20 {ceilingLamp}
		sel_0 1
		sel_213 11
		sel_301 40
		sel_302 32
	)
)

(instance axes of Feature
	(properties
		sel_20 {axes}
		sel_1 123
		sel_0 83
		sel_213 12
		sel_6 71
		sel_7 105
		sel_8 96
		sel_9 142
		sel_301 40
	)
)

(instance needlepoint of Feature
	(properties
		sel_20 {needlepoint}
		sel_1 153
		sel_0 93
		sel_213 13
		sel_6 88
		sel_7 145
		sel_8 98
		sel_9 162
		sel_301 40
	)
)

(instance plant of Feature
	(properties
		sel_20 {plant}
		sel_1 214
		sel_0 78
		sel_213 14
		sel_6 72
		sel_7 208
		sel_8 84
		sel_9 221
		sel_301 40
	)
)

(instance transom of Feature
	(properties
		sel_20 {transom}
		sel_1 252
		sel_0 75
		sel_213 15
		sel_6 70
		sel_7 245
		sel_8 80
		sel_9 259
		sel_301 40
	)
)

(instance diploma of Feature
	(properties
		sel_20 {diploma}
		sel_1 272
		sel_0 131
		sel_82 34
		sel_213 16
		sel_6 81
		sel_7 265
		sel_8 114
		sel_9 280
		sel_301 40
	)
)

(instance pic1 of Feature
	(properties
		sel_20 {pic1}
		sel_1 47
		sel_0 76
		sel_213 17
		sel_6 59
		sel_7 40
		sel_8 93
		sel_9 54
		sel_301 40
	)
)

(instance pic2 of Feature
	(properties
		sel_20 {pic2}
		sel_1 65
		sel_0 92
		sel_213 18
		sel_6 77
		sel_7 57
		sel_8 108
		sel_9 74
		sel_301 40
	)
)

(instance pic3 of Feature
	(properties
		sel_20 {pic3}
		sel_1 82
		sel_0 84
		sel_213 19
		sel_6 71
		sel_7 76
		sel_8 98
		sel_9 88
		sel_301 40
	)
)

(instance genericDrawer of Feature
	(properties
		sel_20 {genericDrawer}
		sel_0 1
		sel_301 40
		sel_302 2
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(gMessager sel_295: 48 param1)
			)
			(8
				(gMessager sel_295: 48 param1)
			)
			(else
				(super sel_300: param1)
			)
		)
	)

	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond
				(
					(and
						(<= 169 gMouseX)
						(<= gMouseX 180)
						(<= 96 gMouseY)
						(<= gMouseY 102)
					)
					(= sel_213 20)
				)
				(
					(and
						(<= 181 gMouseX)
						(<= gMouseX 193)
						(<= 96 gMouseY)
						(<= gMouseY 102)
					)
					(= sel_213 21)
				)
				(
					(and
						(<= 194 gMouseX)
						(<= gMouseX 207)
						(<= 96 gMouseY)
						(<= gMouseY 102)
					)
					(= sel_213 22)
				)
				(
					(and
						(<= 208 gMouseX)
						(<= gMouseX 221)
						(<= 96 gMouseY)
						(<= gMouseY 102)
					)
					(= sel_213 23)
				)
				(
					(and
						(<= 169 gMouseX)
						(<= gMouseX 180)
						(<= 103 gMouseY)
						(<= gMouseY 111)
					)
					(= sel_213 24)
				)
				(
					(and
						(<= 181 gMouseX)
						(<= gMouseX 193)
						(<= 103 gMouseY)
						(<= gMouseY 111)
					)
					(= sel_213 25)
				)
				(
					(and
						(<= 194 gMouseX)
						(<= gMouseX 207)
						(<= 103 gMouseY)
						(<= gMouseY 111)
					)
					(= sel_213 26)
				)
				(
					(and
						(<= 208 gMouseX)
						(<= gMouseX 221)
						(<= 103 gMouseY)
						(<= gMouseY 111)
					)
					(= sel_213 27)
				)
				(
					(and
						(<= 169 gMouseX)
						(<= gMouseX 180)
						(<= 112 gMouseY)
						(<= gMouseY 122)
					)
					(= sel_213 28)
				)
				(
					(and
						(<= 181 gMouseX)
						(<= gMouseX 193)
						(<= 112 gMouseY)
						(<= gMouseY 122)
					)
					(= sel_213 29)
				)
				(
					(and
						(<= 194 gMouseX)
						(<= gMouseX 207)
						(<= 112 gMouseY)
						(<= gMouseY 122)
					)
					(= sel_213 30)
				)
				(
					(and
						(<= 208 gMouseX)
						(<= gMouseX 221)
						(<= 112 gMouseY)
						(<= gMouseY 122)
					)
					(= sel_213 31)
				)
				(
					(and
						(<= 169 gMouseX)
						(<= gMouseX 180)
						(<= 123 gMouseY)
						(<= gMouseY 130)
					)
					(= sel_213 32)
				)
				(
					(and
						(<= 181 gMouseX)
						(<= gMouseX 193)
						(<= 123 gMouseY)
						(<= gMouseY 130)
					)
					(= sel_213 33)
				)
				(
					(and
						(<= 194 gMouseX)
						(<= gMouseX 207)
						(<= 123 gMouseY)
						(<= gMouseY 130)
					)
					(= sel_213 34)
				)
				(
					(and
						(<= 208 gMouseX)
						(<= gMouseX 221)
						(<= 123 gMouseY)
						(<= gMouseY 130)
					)
					(= sel_213 35)
				)
			)
		)
	)
)

(instance inDeskLamp of Inset
	(properties
		sel_20 {inDeskLamp}
		sel_2 550
		sel_3 5
		sel_1 61
		sel_0 95
		sel_570 1
		sel_213 45
	)

	(method (sel_110)
		(lampCycle sel_110: sel_102:)
		(if (IsFlag 40)
			(self sel_4: 1)
		else
			(self sel_4: 0)
		)
		(if (IsFlag 64)
			(bulbMask sel_110:)
		)
		(super sel_110: &rest)
	)

	(method (sel_111)
		(bulbMask sel_111:)
		(super sel_111:)
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(if (not (IsFlag 64))
					(self sel_146: sDeskLampOnOff)
				else
					(gMessager sel_295: sel_213 param1)
				)
			)
			(1
				(if (not (IsFlag 64))
					(gCurRoom sel_422: inLightBulb)
				else
					(gMessager sel_295: sel_213 param1)
				)
			)
			(8
				(if (not (IsFlag 64))
					(gCurRoom sel_422: inLightBulb)
				else
					(gMessager sel_295: sel_213 param1)
				)
			)
			(39
				(if (and (not (IsFlag 40)) (not (IsFlag 64)))
					(gCurRoom sel_146: sReadCarbonPaper)
					(self sel_111:)
				else
					(gMessager sel_295: sel_213 param1 6)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance lampCycle of Prop
	(properties
		sel_20 {lampCycle}
		sel_1 61
		sel_0 95
		sel_2 550
		sel_3 4
		sel_60 15
		sel_14 16
	)
)

(instance bulbMask of View
	(properties
		sel_20 {bulbMask}
		sel_1 79
		sel_0 110
		sel_2 550
		sel_3 5
		sel_4 2
		sel_60 14
		sel_14 16
	)
)

(instance inLightBulb of Inset
	(properties
		sel_20 {inLightBulb}
		sel_2 550
		sel_4 5
		sel_1 61
		sel_0 95
		sel_570 1
		sel_213 43
	)

	(method (sel_110)
		(if (IsFlag 40)
			(self sel_4: 3)
		else
			(self sel_4: 5)
		)
		(super sel_110: &rest)
	)

	(method (sel_300 param1)
		(switch param1
			(1
				(if (IsFlag 40)
					(gMessager sel_295: 43 1 4)
				else
					(gMessager sel_295: 43 1 3)
				)
			)
			(8
				(self sel_300: 1)
			)
			(4
				(cond
					((and local0 (IsFlag 40))
						(gCurRoom sel_146: sGetLightBulb)
						(self sel_111:)
					)
					((IsFlag 40)
						(gMessager sel_295: 43 4 2)
					)
					(else
						(gMessager sel_295: 43 4 1)
					)
				)
			)
			(39
				(if (not (IsFlag 40))
					(gCurRoom sel_146: sReadCarbonPaper)
					(self sel_111:)
				else
					(gMessager sel_295: 45 39 6)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance inCarbonPaper of Inset
	(properties
		sel_20 {inCarbonPaper}
		sel_2 550
		sel_4 4
		sel_1 25
		sel_0 145
		sel_570 1
		sel_213 44
	)

	(method (sel_110)
		(if local2
			(self sel_4: 6)
			(= local2 0)
		)
		(super sel_110: &rest)
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(gCurRoom sel_146: sGetCarbonPaper)
				(self sel_111:)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance inShoe of Inset
	(properties
		sel_20 {inShoe}
		sel_2 550
		sel_1 36
		sel_0 111
		sel_570 1
		sel_213 40
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(gCurRoom sel_146: sGetShoe)
				(self sel_111:)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance inHairs of Inset
	(properties
		sel_20 {inHairs}
		sel_2 550
		sel_4 1
		sel_1 48
		sel_0 119
		sel_570 1
		sel_213 41
	)
)

(instance inDressShred of Inset
	(properties
		sel_20 {inDressShred}
		sel_2 550
		sel_4 2
		sel_1 58
		sel_0 109
		sel_570 1
		sel_213 42
	)
)

(instance sDeskLampOnOff of Script
	(properties
		sel_20 {sDeskLampOnOff}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(if (IsFlag 40)
					(deskLamp sel_156: 1)
					(lampCycle
						sel_110:
						sel_156: (lampCycle sel_246:)
						sel_161: CT 5 -1 self
					)
				else
					(deskLamp sel_156: 0)
					(lampCycle sel_110: sel_156: 0 sel_161: CT 6 1 self)
				)
			)
			(1
				(sFX sel_40: 558 sel_39:)
				(if (IsFlag 40)
					(inDeskLamp sel_4: 0 sel_573:)
				else
					(inDeskLamp sel_4: 1 sel_573:)
				)
				(= sel_136 1)
			)
			(2
				(if (IsFlag 40)
					(ClearFlag 40)
					(lampCycle sel_161: Beg self)
				else
					(SetFlag 40)
					(lampCycle sel_161: End self)
				)
			)
			(3
				(= sel_139 30)
			)
			(4
				(lampCycle sel_111: sel_81:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetLightBulb of Script
	(properties
		sel_20 {sGetLightBulb}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_141 (Sound sel_109:))
				(gEgo sel_312: PolyPath 82 156 self)
			)
			(1
				(gEgo
					sel_2: 552
					sel_155: 0
					sel_156: 0
					sel_153: 82 156
					sel_244: 12
					sel_63: 13
					sel_161: End self
				)
			)
			(2
				(gEgo sel_161: UnscrewBulb 6 sel_141 self)
			)
			(3
				(gEgo sel_350: 23)
				((ScriptID 21 0) sel_57: 792) ; addCluesCode
				(SetFlag 64)
				(gEgo sel_161: Beg self)
			)
			(4
				(gEgo sel_585: 831 sel_3: 8 sel_4: 0)
				(= sel_136 1)
			)
			(5
				(gGame sel_588:)
				(sel_141 sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetCarbonPaper of Script
	(properties
		sel_20 {sGetCarbonPaper}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 85 156 self)
			)
			(1
				(gEgo
					sel_2: 552
					sel_155: 3
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(2
				(= sel_139 90)
			)
			(3
				(= local2 1)
				(gCurRoom sel_422: inCarbonPaper)
				(= sel_139 90)
			)
			(4
				(inCarbonPaper sel_111:)
				(= sel_139 30)
			)
			(5
				(gEgo sel_585: 831 sel_3: 0)
				(gEgo sel_350: 29)
				((ScriptID 21 0) sel_57: 798) ; addCluesCode
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetShoe of Script
	(properties
		sel_20 {sGetShoe}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 2)
			)
			(1
				(gEgo sel_312: PolyPath 71 151 self)
			)
			(2
				(gEgo sel_253: 90)
				(= sel_136 15)
			)
			(3
				(gEgo
					sel_2: 552
					sel_155: 1
					sel_156: 0
					sel_63: 15
					sel_244: 12
					sel_161: CT 3 1 self
				)
			)
			(4
				(shoe sel_111:)
				(gEgo sel_161: End self)
				(gEgo sel_63: -1)
			)
			(5
				(gEgo sel_350: 30)
				((ScriptID 21 0) sel_57: 799) ; addCluesCode
				(gGame sel_87: 1 178)
				(= sel_136 3)
			)
			(6
				(gEgo sel_585: 831)
				(gEgo sel_312: PolyPath 90 186 self)
			)
			(7
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sTalkYvette of Script ; UNUSED
	(properties
		sel_20 {sTalkYvette}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 68 148 self)
			)
			(1
				(gEgo
					sel_2: 552
					sel_155: 5
					sel_156: 0
					sel_153: 77 146
					sel_244: 12
					sel_161: ForwardCounter 2 self
				)
			)
			(2
				(yvette sel_161: Fwd)
				(gEgo
					sel_155: 6
					sel_156: 0
					sel_153: 75 146
					sel_161: ForwardCounter 2 self
				)
			)
			(3
				(yvette sel_161: 0)
				(gEgo
					sel_155: 5
					sel_156: 0
					sel_153: 77 146
					sel_161: ForwardCounter 2 self
				)
			)
			(4
				(gEgo sel_585: 831 sel_244: 6 sel_153: 68 148)
				(Face gEgo yvette)
				(= sel_136 1)
			)
			(5
				(gEgo sel_312: PolyPath (gEgo sel_1:) 250 self)
			)
			(6
				(gCurRoom sel_399: 510)
			)
		)
	)
)

(instance sEmbraceStop of Script
	(properties
		sel_20 {sEmbraceStop}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 2)
			)
			(1
				(gGame sel_87: 1 176)
				(embrace sel_244: 6 sel_155: 1 sel_156: 0 sel_161: End self)
			)
			(2
				(gMessager sel_295: 2 0 2 0 self 1550)
			)
			(3
				(gEgo sel_312: PolyPath (gEgo sel_1:) 260 self)
			)
			(4
				(gCurRoom sel_399: gPrevRoomNum)
			)
		)
	)
)

(instance sBackRubViewing of Script
	(properties
		sel_20 {sBackRubViewing}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 2)
			)
			(1
				(if (== local1 backRub)
					(gEgo sel_312: PolyPath 171 183 self)
				else
					(= sel_136 1)
				)
			)
			(2
				(Face gEgo backRub)
				(= sel_139 300)
			)
			(3
				(gCast sel_119: 102)
				(gCurRoom sel_417: 556)
				(= sel_139 180)
			)
			(4
				(gCast sel_119: 216)
				(gCurRoom sel_417: 550)
				(= sel_136 1)
			)
			(5
				(= sel_139 360)
			)
			(6
				(local1 sel_300: 0)
				(self sel_111:)
			)
		)
	)
)

(instance sBackRubInterrupted of Script
	(properties
		sel_20 {sBackRubInterrupted}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_87: 1 177)
				(backRub sel_155: 3 sel_156: 0 sel_161: End self)
			)
			(1
				(gMessager sel_295: 3 0 0 0 self 1550)
			)
			(2
				(gEgo sel_312: PolyPath (gEgo sel_1:) 250 self)
			)
			(3
				(gCurRoom sel_399: 510)
			)
		)
	)
)

(instance sEmbrace of Script
	(properties
		sel_20 {sEmbrace}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 1)
			)
			(1
				(if local3
					(= sel_136 1)
				else
					(gEgo sel_312: PolyPath 172 176 self)
				)
			)
			(2
				(if local3
					(= sel_136 1)
				else
					(Face gEgo embrace)
					(= sel_139 60)
				)
			)
			(3
				(embrace sel_156: 0 sel_244: 24 sel_161: CT 3 1)
				(= sel_139 (* 3 (Random 60 120)))
			)
			(4
				(embrace sel_161: End)
				(= sel_139 (* 4 (Random 60 120)))
			)
			(5
				(if (== (++ local3) 2)
					(sel_42 sel_146: sEmbraceStop)
				else
					(self sel_110:)
				)
			)
		)
	)
)

(instance sReadCarbonPaper of Script
	(properties
		sel_20 {sReadCarbonPaper}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 68 159 self)
			)
			(1
				(gEgo sel_161: StopWalk -1)
				(= sel_139 60)
			)
			(2
				(gEgo sel_2: 552 sel_155: 1 sel_156: 0 sel_161: End self)
			)
			(3
				(= sel_139 120)
			)
			(4
				(gMessager sel_295: 45 39 7)
				(gGame sel_87: 1 170)
				(= sel_136 1)
			)
			(5
				(= sel_139 60)
			)
			(6
				(gEgo sel_585: 831 sel_3: 6 sel_4: 5)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sErnieDead of Script
	(properties
		sel_20 {sErnieDead}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_136 15)
			)
			(1
				(gEgo sel_312: PolyPath 160 179 self)
			)
			(2
				(Face gEgo yvette)
				(= sel_136 5)
			)
			(3
				(gMessager sel_295: 4 0 0 0 self 1550)
			)
			(4
				(gEgo sel_312: PolyPath 160 270 self)
			)
			(5
				(gCurRoom sel_399: 510)
			)
		)
	)
)

(instance sOlympiaEnters of Script
	(properties
		sel_20 {sOlympiaEnters}
	)

	(method (sel_144 param1 &tmp temp0 temp1 temp2 temp3)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= sel_139 60)
			)
			(1
				(gEgo sel_253: 180)
				(olympia sel_110: sel_161: Walk sel_312: PolyPath 150 186 self)
				(= temp0 (/ (* 110 ((gEgo sel_322:) sel_577:)) 100))
				(= temp1 ((gEgo sel_322:) sel_575:))
				(= temp2 (/ (* 110 (+ 1 ((gEgo sel_322:) sel_578:))) 100))
				(= temp3 ((gEgo sel_322:) sel_576:))
				(olympia sel_320: Scaler temp0 temp2 temp1 temp3)
			)
			(2
				(Face olympia gEgo)
				(Face gEgo olympia)
				(= sel_136 1)
			)
			(3
				(olympia sel_161: StopWalk -1)
				(= sel_136 1)
			)
			(4
				(olympiaConv
					sel_118: 1550 1 0 1 1
					sel_118: 1550 1 0 1 2
					sel_118: 1550 1 0 1 3
					sel_110: self
				)
			)
			(5
				(olympia sel_161: Walk sel_312: PolyPath 194 167 self)
			)
			(6
				(Face gEgo olympia)
				(Face olympia paperCutter)
				(= sel_136 1)
			)
			(7
				(olympia sel_161: StopWalk -1)
				(= sel_136 1)
			)
			(8
				(= sel_139 120)
			)
			(9
				(olympiaConv sel_118: 1550 1 0 1 4 sel_110: self)
			)
			(10
				(olympia sel_161: Walk sel_312: PolyPath 150 186 self)
				(= sel_137 3)
			)
			(11
				(olympiaConv sel_118: 1550 1 0 1 5 sel_110:)
			)
			(12
				(olympia sel_161: StopWalk -1)
			)
			(13
				(Face gEgo olympia)
				(Face olympia gEgo)
				(= sel_136 1)
			)
			(14
				(olympiaConv sel_118: 1550 1 0 1 6 sel_110: self)
			)
			(15
				(olympia
					sel_161: Walk
					sel_312: PolyPath (olympia sel_1:) 250 self
				)
			)
			(16
				(Face gEgo olympia)
				(= sel_136 1)
			)
			(17
				(= sel_139 120)
			)
			(18
				(olympia sel_111:)
				(Face gEgo paperCutter)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(class UnscrewBulb of Osc
	(properties
		sel_20 {UnscrewBulb}
		sel_607 1
	)

	(method (sel_110 param1 param2 param3 param4)
		(if (>= argc 2)
			(= sel_469 param2)
			(if (>= argc 3)
				(= sel_607 param3)
				(if (>= argc 4)
					(= sel_143 param4)
				)
			)
		)
		(super sel_110: param1 param2 param4)
	)

	(method (sel_57 &tmp temp0)
		(if (or (> (= temp0 (self sel_241:)) 8) (< temp0 7))
			(= sel_239 (- sel_239))
			(self sel_242:)
		else
			(sel_42 sel_4: temp0)
		)
	)

	(method (sel_242)
		(sel_607 sel_40: 553 sel_39:)
		(super sel_242:)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_8 189
		sel_9 247
		sel_33 11
		sel_583 3
		sel_213 49
	)
)

(instance olympiaConv of Conversation
	(properties
		sel_20 {olympiaConv}
	)
)
