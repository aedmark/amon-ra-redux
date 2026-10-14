;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use n027)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use PolyPath)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm600 0
	northDoor 1
	eastDoor 2
)

(local
	local0
	local1
	local2
	local3
)

(instance rm600 of LBRoom
	(properties
		name {rm600}
		noun 6
		picture 600
		north 650
		east 610
		south 530
		vanishingY 40
	)

	(method (init)
		(gEgo init: normalize: 831 setScale: Scaler 102 0 190 40)
		(self setRegions: 90)
		(switch gPrevRoomNum
			(521 ; meanWhile
				(gGame handsOff:)
				(gEgo posn: 160 170)
				(self setScript: sOlympiaEnters)
			)
			(north
				(gEgo edgeHit: 0 setHeading: 180)
				(gGameMusic2 stop:)
			)
			(south
				(gEgo x: 160)
				(gGameMusic2 fade:)
				(gGame handsOn:)
			)
			(east
				(gEgo edgeHit: 0 setHeading: 270)
				(eastDoor caller: self)
				(gGameMusic2 stop:)
			)
			(else
				(gEgo wearingGown: 1 posn: 160 170)
				(gGame handsOn:)
			)
		)
		(WrapMusic pause: 0)
		(super init:)
		(if (IsFlag 10)
			(glass approachVerbs: 4 1 setCel: (glass lastCel:) init:)
			(if (not (gEgo has: 15))
				(lantern
					approachVerbs: 1 4
					setPri: 14
					y: (+ (lantern y:) 50)
					z: 50
					init:
				)
			)
		else
			(glass approachVerbs: 4 1 init:)
			(lantern approachVerbs: 1 4 init:)
			(Load rsSOUND 600)
		)
		(northDoor approachVerbs: 4 init:)
		(doorbell approachVerbs: 4 init:)
		(eastDoor approachVerbs: 4 init:)
		(columnA init:)
		(columnB init:)
		(columnC init:)
		(columnD init:)
		(archA init:)
		(archB init:)
		(ceiling init:)
		(southExit init:)
		(if (not (IsFlag 16))
			(Load rsSOUND 637)
			(ferret init:)
			(ferretTimer setReal: ferret (Random 15 45))
		else
			(ClearFlag 16)
		)
		(if (and (IsFlag 12) (not (IsFlag 61)))
			(Load rsVIEW 635)
			(Load rsSOUND 636)
			(meatTimer setReal: bugsWithMeat 5)
		)
		(if
			(and
				(== gAct 4)
				(not (== gPrevRoomNum 521)) ; meanWhile
				(not (IsFlag 62))
				(TimeCheck $4108 1) ; can 4:15 am occur?
				(not (IsFlag 92))
			)
			(SetFlag 62)
			(self setScript: sMeanwhile)
		)
		(if (and (not (IsFlag 84)) (== ((ScriptID 90 2) room:) gCurRoomNum)) ; aOlympia
			((ScriptID 90 2) goTo: 650) ; aOlympia
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((StepOn gEgo 2)
				(self setScript: sExitToStairs)
			)
		)
	)

	(method (dispose)
		(ferretTimer dispose: delete:)
		(meatTimer dispose: delete:)
		(if local0
			(ClearFlag 10)
		)
		(WrapMusic pause: 1)
		(super dispose:)
	)

	(method (newRoom)
		(super newRoom: &rest)
		(if
			(and
				(or (== gNewRoomNum north) (== gNewRoomNum south))
				(not (IsFlag 4))
			)
			(cond
				((not (TimeCheck $b102)) 0) ; has 11:15 pm occurred?
				((not (TimeCheck $1310)) ; has 1:45 am occurred?
					(ClearFlag 18)
				)
				(else 0)
			)
		)
		(if (!= gNewRoomNum north)
			(ClearFlag 117)
		)
	)
)

(instance sExitToStairs of Script
	(properties
		name {sExitToStairs}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sBreakGlass of Script
	(properties
		name {sBreakGlass}
	)

	(method (changeState param1 &tmp temp0 temp1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 55 188 self)
			)
			(1
				(if (== register 29)
					(= temp0 48)
					(= temp1 175)
				else
					(= temp0 41)
					(= temp1 176)
				)
				(gEgo setMotion: MoveTo temp0 temp1 self)
			)
			(2
				(gEgo
					view: 601
					setLoop: (if (== register 29) 1 else 2)
					setCel: 0
					setPri: 15
					setCycle: End self
				)
			)
			(3
				(sFX number: 600 flags: 5 loop: 1 play:)
				(glass setCycle: CT 3 1 self)
			)
			(4
				(lantern setPri: 14 y: (+ (lantern y:) 50) z: 50)
				(glass setCycle: End self)
			)
			(5
				(SetFlag 10)
				(glass stopUpd:)
				(gEgo normalize: 831 setMotion: MoveTo 59 187 self)
			)
			(6
				(gEgo setHeading: 270 self)
			)
			(7
				(cond
					((IsFlag 109)
						(gGame handsOn:)
						(self dispose:)
					)
					((and (IsFlag 108) (not (Random 0 2)))
						(Load rsVIEW 814)
						(Load rsSOUND 19)
						(SetFlag 109)
						(self setScript: sTakeAwayLantern)
					)
					((and (not (IsFlag 108)) (Random 0 1))
						(Load rsVIEW 814)
						(Load rsSOUND 19)
						(SetFlag 108)
						(self setScript: sTakeAwayLantern)
					)
					(else
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance sTakeAwayLantern of Script
	(properties
		name {sTakeAwayLantern}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if (and (!= gPrevRoomNum 650) (IsFlag 83))
					(self setScript: sHeimlichFromOffice self)
				else
					((ScriptID 32 0) ; aHeimlich
						init:
						setScale: Scaler 120 0 190 0
						view: 814
						room: gCurRoomNum
						posn: 197 250
						setMotion: PolyPath 79 186 self
					)
					(WrapMusic pause: 1)
					(gGameMusic2 number: 19 flags: 1 loop: -1 play:)
				)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gMessager say: 7 0 0 0 self)
			)
			(4
				(gEgo setMotion: PolyPath (gEgo x:) 240 self)
			)
			(5
				(= local0 1)
				(gGameMusic2 fade:)
				(gCurRoom newRoom: (gCurRoom south:))
				(self dispose:)
			)
		)
	)
)

(instance sHeimlichFromOffice of Script
	(properties
		name {sHeimlichFromOffice}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= cycles 2)
			)
			(1
				(northDoor locked: 1)
				((ScriptID 32 0) ; aHeimlich
					init:
					setScale: 170
					view: 814
					room: gCurRoomNum
					setPri: 6
					setHeading: 180
					posn: (northDoor moveToX:) (northDoor moveToY:)
				)
				(WrapMusic pause: 1)
				(gGameMusic2 number: 19 flags: 1 loop: -1 play:)
				(northDoor setCycle: End self)
				(sFX number: 46 flags: 5 loop: 1 play:)
				(global95 delete: (northDoor doorPoly:))
			)
			(2
				((ScriptID 32 0) ; aHeimlich
					setPri: -1
					setMotion:
						PolyPath
						(northDoor approachX:)
						(northDoor approachY:)
						self
				)
			)
			(3
				(northDoor setCycle: Beg self)
				(sFX number: 47 flags: 5 loop: 1 play:)
				(global95 add: (northDoor doorPoly:))
			)
			(4
				((ScriptID 32 0) setMotion: PolyPath 79 186 self) ; aHeimlich
			)
			(5
				((ScriptID 32 0) setHeading: 270 self) ; aHeimlich
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sFerretRight of Script
	(properties
		name {sFerretRight}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(ferret setLoop: 5 setCycle: Walk setMotion: PolyPath 243 173 self)
				(sFXFerret play:)
			)
			(1
				(if (eastDoor cel:)
					(ferret
						setMotion:
							PolyPath
							(eastDoor moveToX:)
							(eastDoor moveToY:)
							self
					)
				else
					(ferret setMotion: PolyPath 347 210 self)
				)
			)
			(2
				(ferret dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sFerretLeft of Script
	(properties
		name {sFerretLeft}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if (eastDoor cel:)
					(ferret
						posn: (eastDoor moveToX:) (eastDoor moveToY:)
						setLoop: 4
						setCycle: Walk
						setMotion: PolyPath 243 173 self
					)
				else
					(ferret
						posn: 347 210
						setLoop: 4
						setCycle: Walk
						setMotion: PolyPath 243 173 self
					)
				)
				(sFXFerret play:)
			)
			(1
				(ferret setMotion: PolyPath 21 210 self)
			)
			(2
				(ferret dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sDoMeat of Script
	(properties
		name {sDoMeat}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(sFXBeetles play: 0 fade: 127 25 10 0 self)
			)
			(1
				(sFX number: 46 flags: 5 play:)
				(eastDoor setCycle: End self)
				(global95 delete: (eastDoor doorPoly:))
			)
			(2
				(bugsWithMeat
					init:
					posn: (eastDoor moveToX:) (eastDoor moveToY:)
					setLoop: 0
					setCycle: Walk
					setMotion:
						PolyPath
						(eastDoor approachX:)
						(eastDoor approachY:)
						self
				)
			)
			(3
				(sFX number: 47 flags: 5 play:)
				(eastDoor setCycle: Beg self)
				(global95 add: (eastDoor doorPoly:))
			)
			(4
				(gGame handsOn:)
				(bugsWithMeat setMotion: PolyPath 243 173 self)
			)
			(5
				(bugsWithMeat setMotion: PolyPath 21 210 self)
			)
			(6
				(sFXBeetles fade:)
				(SetFlag 61)
				(bugsWithMeat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sOlympiaEnters of Script
	(properties
		name {sOlympiaEnters}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= cycles 15)
			)
			(1
				(olympia
					posn: 100 210
					setCycle: Walk
					setScale: Scaler 102 0 190 40
					setPri: -1
					setMotion:
						PolyPath
						(- (gEgo x:) 20)
						(gEgo y:)
						self
					init:
				)
				(= seconds 2)
			)
			(2
				(Face gEgo olympia)
			)
			(3
				(Face gEgo olympia self)
			)
			(4
				(gMessager say: 1 0 24 0 self 1892)
			)
			(5
				(olympia setMotion: PolyPath 285 176 self)
			)
			(6
				(eastDoor setCycle: End self)
				(global95 delete: (eastDoor doorPoly:))
			)
			(7
				(olympia setMotion: PolyPath 314 157 self)
			)
			(8
				(global95 add: (eastDoor doorPoly:))
				(eastDoor setCycle: Beg self)
			)
			(9
				(gGame handsOn:)
				(olympia dispose:)
				(ClearFlag 62)
				(self dispose:)
			)
		)
	)
)

(instance ferret of Actor
	(properties
		name {ferret}
		x 21
		y 210
		view 632
		loop 5
		signal 16384
		cycleSpeed 4
		xStep 4
		moveSpeed 4
	)

	(method (doVerb param1)
		(switch param1
			(6
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(259
						(if (proc27_0 12 global298)
							(gMessager say: 1 6 1 0 0 1894)
						else
							(gMessager say: 1 6 4 0 0 1894)
							(proc27_1 12 @global298)
						)
					)
					(260
						(if (proc27_0 12 global299)
							(gMessager say: 1 6 1 0 0 1894)
						else
							(gMessager say: 1 6 5 0 0 1894)
							(proc27_1 12 @global299)
						)
					)
					(265
						(if (proc27_0 12 global304)
							(gMessager say: 1 6 1 0 0 1894)
						else
							(gMessager say: 1 6 10 0 0 1894)
							(proc27_1 12 @global304)
						)
					)
					(266
						(if (proc27_0 12 global305)
							(gMessager say: 1 6 1 0 0 1894)
						else
							(gMessager say: 1 6 11 0 0 1894)
							(proc27_1 12 @global305)
						)
					)
					(270
						(if (proc27_0 12 global309)
							(gMessager say: 1 6 1 0 0 1894)
						else
							(gMessager say: 1 6 15 0 0 1894)
							(proc27_1 12 @global309)
						)
					)
					(781
						(if (proc27_0 12 global333)
							(gMessager say: 1 6 1 0 0 1894)
						else
							(gMessager say: 1 6 39 0 0 1894)
							(proc27_1 12 @global333)
						)
					)
					(785
						(if (proc27_0 12 global337)
							(gMessager say: 1 6 1 0 0 1894)
						else
							(gMessager say: 1 6 43 0 0 1894)
							(proc27_1 12 @global337)
						)
					)
					(800
						(if (proc27_0 12 global352)
							(gMessager say: 1 6 1 0 0 1894)
						else
							(gMessager say: 1 6 58 0 0 1894)
							(proc27_1 12 @global352)
						)
					)
					(else
						(gMessager say: 1 6 81 0 0 1894)
					)
				)
			)
			(41
				(gMessager say: 1 41 0 0 0 1894)
			)
			(8
				(gMessager say: 1 8 0 0 0 1894)
			)
			(19
				(gMessager say: 1 19 0 0 0 1894)
			)
			(24
				(gMessager say: 1 24 0 0 0 1894)
			)
			(25
				(gMessager say: 1 25 0 0 0 1894)
			)
			(23
				(gMessager say: 1 23 0 0 0 1894)
			)
			(2
				(gMessager say: 1 2 0 0 0 1894)
			)
			(4
				(gMessager say: 1 4 0 0 0 1894)
			)
			(1
				(gMessager say: 1 1 0 0 0 1894)
			)
			(else
				(gMessager say: 1 0 0 0 0 1894)
			)
		)
	)

	(method (cue)
		(SetFlag 16)
		(if (Random 0 1)
			(self setScript: sFerretLeft)
		else
			(self setScript: sFerretRight)
		)
	)
)

(instance ferretTimer of Timer
	(properties
		name {ferretTimer}
	)
)

(instance bugsWithMeat of Actor
	(properties
		name {bugsWithMeat}
		noun 12
		view 635
		signal 16384
	)

	(method (doVerb param1)
		(switch param1
			(6
				(gMessager say: 12 2)
			)
			(else
				(if (not (OneOf param1 3 1 4 2))
					(gMessager say: 12)
				else
					(super doVerb: param1)
				)
			)
		)
	)

	(method (cue)
		(if (gCurRoom script:)
			(meatTimer setReal: self 5)
		else
			(self setScript: sDoMeat)
		)
	)
)

(instance meatTimer of Timer
	(properties
		name {meatTimer}
	)
)

(instance lantern of View
	(properties
		name {lantern}
		x 22
		y 150
		approachX 55
		approachY 188
		view 600
		priority 13
		signal 17
	)

	(method (doVerb param1)
		(switch param1
			(4
				(lantern dispose:)
				(gEgo get: 15)
				((ScriptID 21 0) doit: 784) ; addCluesCode
			)
			(1
				(gCurRoom setInset: inLantern)
			)
			(8
				(gCurRoom setInset: inLantern)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance olympia of Actor
	(properties
		name {olympia}
		x 256
		y 184
		view 820
		cel 5
		priority 13
		signal 16400
	)
)

(instance glass of Prop
	(properties
		name {glass}
		x 17
		y 159
		noun 5
		approachX 55
		approachY 188
		view 601
		priority 13
		signal 16401
		cycleSpeed 9
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if (IsFlag 10)
					(gMessager say: 5 1 5)
				else
					(gMessager say: 5 1 4)
				)
			)
			(8
				(if (IsFlag 10)
					(super doVerb: param1)
				else
					(gMessager say: 5 8 4)
				)
			)
			(4
				(if (IsFlag 10)
					(gMessager say: 5 4 5)
				else
					(gMessager say: 5 4 4)
				)
			)
			(29
				(cond
					((IsFlag 10)
						(gMessager say: 5 29 5)
					)
					((MuseumRgn nobodyAround:)
						(gCurRoom setScript: sBreakGlass 0 29)
					)
					(else
						(return 1)
					)
				)
			)
			(23
				(cond
					((IsFlag 10)
						(super doVerb: param1)
					)
					((MuseumRgn nobodyAround:)
						(gCurRoom setScript: sBreakGlass 0 23)
					)
					(else
						(return 1)
					)
				)
			)
			(22
				(if (IsFlag 10)
					(super doVerb: param1)
				else
					(gMessager say: 5 22 4)
				)
			)
			(41
				(if (IsFlag 10)
					(super doVerb: param1)
				else
					(gMessager say: 5 41 4)
				)
			)
			(19
				(if (IsFlag 10)
					(super doVerb: param1)
				else
					(gMessager say: 5 19 4)
				)
			)
			(18
				(if (IsFlag 10)
					(super doVerb: param1)
				else
					(gMessager say: 5 18 4)
				)
			)
			(21
				(if (IsFlag 10)
					(super doVerb: param1)
				else
					(gMessager say: 5 21 4)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance northDoor of Door
	(properties
		name {northDoor}
		x 152
		y 109
		noun 8
		approachX 134
		approachY 174
		view 600
		loop 1
		entranceTo 650
		listenVerb 38
		moveToX 134
		moveToY 155
		enterType 0
		exitType 0
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 38)
	)

	(method (listen)
		(cond
			((or (IsFlag 84) (== gPrevRoomNum (gCurRoom north:)) local3)
				(super listen: &rest)
			)
			((IsFlag 83)
				(gMessager say: 1 38 4 0 0 1600)
				(northDoor locked: 1)
				(SetFlag 84)
			)
			((IsFlag 82)
				(gMessager say: 1 38 3 0 0 1600)
				(northDoor locked: 1)
				(SetFlag 83)
				(= local3 1)
			)
			((IsFlag 81)
				(gMessager say: 1 38 2 0 0 1600)
				(northDoor locked: 1)
				(SetFlag 82)
				(= local3 1)
			)
			(else
				(gMessager say: 1 38 1 0 0 1600)
				(northDoor locked: 1)
				(SetFlag 81)
			)
		)
	)

	(method (createPoly)
		(super createPoly: 109 161 109 149 161 149 161 161 112 161)
	)
)

(instance eastDoor of Door
	(properties
		name {eastDoor}
		x 290
		y 96
		noun 9
		approachX 269
		approachY 175
		view 600
		loop 2
		entranceTo 610
		moveToX 310
		moveToY 158
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 285 152 306 157 305 164 282 159)
	)
)

(instance inLantern of Inset
	(properties
		name {inLantern}
		view 600
		cel 1
		y 128
		disposeNotOnMe 1
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gMessager say: 19 1 0 0 0 15)
			)
			(8
				(gMessager say: 19 8 0 0 0 15)
			)
			(4
				(lantern dispose:)
				(gEgo get: 15)
				((ScriptID 21 0) doit: 784) ; addCluesCode
				(self dispose:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance doorbell of Feature
	(properties
		name {doorbell}
		x 112
		y 138
		noun 2
		nsTop 133
		nsLeft 109
		nsBottom 142
		nsRight 116
		sightAngle 40
		approachX 115
		approachY 170
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gMessager say: 2 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance columnA of Feature
	(properties
		name {columnA}
		x 99
		y 116
		noun 1
		nsTop 67
		nsLeft 89
		nsBottom 165
		nsRight 109
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(1
				(switch local1
					(0
						(gMessager say: 1 1 1)
					)
					(1
						(gMessager say: 1 1 2)
					)
					(else
						(gMessager say: 1 1 3)
					)
				)
				(++ local1)
			)
			(4
				(gMessager say: 1 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance columnB of Feature
	(properties
		name {columnB}
		x 179
		y 116
		noun 1
		nsTop 72
		nsLeft 169
		nsBottom 161
		nsRight 189
		sightAngle 40
	)

	(method (doVerb)
		(columnA doVerb: &rest)
	)
)

(instance columnC of Feature
	(properties
		name {columnC}
		x 234
		y 179
		noun 1
		nsLeft 217
		nsBottom 189
		nsRight 251
		sightAngle 40
	)

	(method (doVerb)
		(columnA doVerb: &rest)
	)
)

(instance columnD of Feature
	(properties
		name {columnD}
		x 312
		y 101
		noun 1
		nsTop 25
		nsLeft 306
		nsBottom 177
		nsRight 319
		sightAngle 40
	)

	(method (doVerb)
		(columnA doVerb: &rest)
	)
)

(instance archA of Feature
	(properties
		name {archA}
		x 134
		y 96
		noun 10
		nsTop 87
		nsLeft 114
		nsBottom 105
		nsRight 154
		sightAngle 40
	)
)

(instance archB of Feature
	(properties
		name {archB}
		x 293
		y 86
		noun 10
		nsTop 79
		nsLeft 288
		nsBottom 93
		nsRight 299
		sightAngle 40
	)
)

(instance ceiling of Feature
	(properties
		name {ceiling}
		x 136
		y 28
		noun 3
		nsLeft 57
		nsBottom 56
		nsRight 216
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(1
				(switch local2
					(0
						(gMessager say: 3 1 1)
					)
					(else
						(gMessager say: 3 1 2)
					)
				)
				(++ local2)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		name {southExit}
		nsTop 185
		nsLeft 46
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 4
	)
)

(instance sFX of Sound
	(properties
		name {sFX}
		flags 1
	)
)

(instance sFXBeetles of Sound
	(properties
		name {sFXBeetles}
		flags 1
		number 636
		loop -1
	)
)

(instance sFXFerret of Sound
	(properties
		name {sFXFerret}
		flags 1
		number 637
	)
)

(instance sMeanwhile of Script
	(properties
		name {sMeanwhile}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(switch gPrevRoomNum
					((gCurRoom north:)
						(gEgo edgeHit: 0 setHeading: 180)
						(gGameMusic2 stop:)
					)
					((gCurRoom south:)
						(gEgo x: 160)
					)
					((gCurRoom east:)
						(gEgo edgeHit: 0 setHeading: 270)
						(eastDoor caller: self)
						(gGameMusic2 stop:)
					)
					(else
						(gEgo wearingGown: 1 posn: 160 170)
					)
				)
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 521)
			)
		)
	)
)
