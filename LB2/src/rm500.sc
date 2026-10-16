;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm500 of LBRoom
	(properties
		name {rm500}
		noun 40
		picture 500
		north 420
		south 510
		vanishingX 0
	)

	(method (init)
		(LoadMany rsVIEW 500 504 505 831)
		(Load rsPIC 501)
		(Load rsSOUND 501 19)
		(if (IsFlag 4)
			(Load rsSOUND 502)
		)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $3104 1))) ; can 3:15 am occur?
			(LoadMany rsPIC 556 505)
			(LoadMany rsSOUND 500 3 6 84)
		)
		(gEgo
			init:
			normalize: (if (== gAct 5) 426 else 831)
			setScale: Scaler 100 70 190 120
		)
		(self setRegions: 90)
		(gGame handsOff:)
		(switch gPrevRoomNum
			(north
				(gEgo x: 103 y: 159 setHeading: 180)
				(cond
					((== gAct 5)
						(self setScript: sLauraDies)
					)
					((and (== gAct 3) (TimeCheck $2140) (not (IsFlag 85))) ; has 2:15 am occurred?
						(if (== ((ScriptID 90 1) room:) gCurRoomNum) ; aCountess
							((ScriptID 90 1) moveTo: -2) ; aCountess
						)
						(if (== ((ScriptID 90 2) room:) gCurRoomNum) ; aOlympia
							((ScriptID 90 2) moveTo: -2) ; aOlympia
						)
						(self setScript: sMeeting)
					)
					(else
						(self setScript: sEnterNorth)
					)
				)
			)
			(south
				(gEgo x: 260 y: 200 setHeading: 315)
				(self setScript: sEnterSouth)
			)
			(else
				(gEgo posn: 78 176)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (and (== gAct 3) (TimeCheck $2140) (not (IsFlag 85))) ; has 2:15 am occurred?
			(= local3 ((ScriptID 90 3) room:)) ; aORiley
			((ScriptID 90 3) ; aORiley
				originalView: 818
				view: 818
				moveTo: gCurRoomNum
				posn: 227 179
				setLoop: 8
				setCel: 1
			)
			((ScriptID 32 0) ; aHeimlich
				originalView: 814
				room: gCurRoomNum
				init:
				posn: 206 179
				setLoop: 8
				setCel: 0
			)
			(WrapMusic pause:)
			(gGameMusic2 number: 350 loop: -1 flags: 1 play:)
		)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $3104 1))) ; can 3:15 am occur?
			(yvetteStatue init: stopUpd:)
			(gCurRoom
				addObstacle:
					(= local1
						((Polygon new:)
							type: 2
							init: 135 183 180 183 191 189 142 189
							yourself:
						)
					)
			)
		)
		(if (not (gEgo has: 8))
			(keyGlint init: approachVerbs: 4 1 8 setScript: sKeyGlint)
		)
		(bobPortrait init:)
		(rickPortrait init:)
		(leftWall init:)
		(dennisPortrait init:)
		(suziPortrait init:)
		(boschPortrait init:)
		(erwinPortrait init:)
		(johnPortrait init:)
		(bench init:)
		(sculpture1 init:)
		(sculpture2 init:)
		(ceiling init:)
		(borderCeiling init:)
		(southExitFeature init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(gEgo edgeHit: 1)
				(self newRoom: north)
			)
		)
	)

	(method (newRoom param1)
		(cond
			((and (== gAct 3) (IsFlag 85) (TimeCheck $0080))
				(= param1 26)
			)
			((== gAct 2)
				(gGameMusic2 stop:)
				(gGameMusic1 pause: 0)
			)
			((or (> gAct 4) (and (== gAct 4) (TimeCheck $3104 1))) ; can 3:15 am occur?
				(local1 dispose:)
			)
		)
		(super newRoom: param1)
	)
)

(instance sLauraDies of Script
	(properties
		name {sLauraDies}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gEgo setMotion: PolyPath 152 166 self)
			)
			(1
				(Face gEgo oRiley)
				(oRiley
					init:
					view: 423
					posn: 99 150
					setScale: 165
					setHeading: 180
					setCycle: StopWalk -1
					setMotion: PolyPath 124 161 self
				)
			)
			(2
				(oRiley
					view: 424
					posn: (+ (oRiley x:) 4) (oRiley y:)
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo setMotion: 0 view: 858 setLoop: 4 setCycle: End self)
				(sFX number: 80 flags: 5 play:)
			)
			(4
				(= ticks 60)
			)
			(5
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance oRiley of Actor
	(properties
		name {oRiley}
		x 227
		y 179
		view 818
		loop 8
		cel 1
	)
)

(instance yvetteStatue of Prop
	(properties
		name {yvetteStatue}
		x 150
		y 141
		noun 8
		approachX 185
		approachY 187
		view 504
		priority 15
		signal 16
	)

	(method (init)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $3104))) ; has 3:15 am occurred?
			(self cel: 8 stopUpd:)
		)
		(super init: &rest)
	)

	(method (doVerb param1)
		(switch param1
			(29
				(if
					(not
						(cond
							((> gAct 4))
							((== gAct 4)
								(TimeCheck $3104) ; has 3:15 am occurred?
							)
						)
					)
					(if (MuseumRgn nobodyAround:)
						(gCurRoom setScript: sSmashPlaster)
					else
						(return 1)
					)
				)
			)
			(1
				(if (== (yvetteStatue cel:) (yvetteStatue lastCel:))
					(gCurRoom setScript: sDeadYvette)
				else
					(gMessager say: 8 1)
				)
			)
			(8
				(if (== (yvetteStatue cel:) (yvetteStatue lastCel:))
					(gCurRoom setScript: sDeadYvette)
				else
					(gMessager say: 8 8)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance keyGlint of Prop
	(properties
		name {keyGlint}
		x 267
		y 116
		noun 20
		view 500
		cycleSpeed 12
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= 250 temp0 284) (<= 100 temp1 130) 1))
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gCurRoom setScript: sBoschPainting)
			)
			(8
				(gCurRoom setScript: sBoschPainting)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance keyGlintInset of Prop
	(properties
		name {keyGlintInset}
		x 198
		y 91
		noun 21
		view 500
		cycleSpeed 12
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= 170 temp0 226) (<= 70 temp1 112) 1))
	)

	(method (doVerb param1)
		(switch param1
			(1
				(inBoschPainting setInset: inSkeletonKey)
			)
			(4
				(inBoschPainting setInset: inSkeletonKey)
			)
			(8
				(inBoschPainting setInset: inSkeletonKey)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance lauraSwingingRt of Actor ; UNUSED
	(properties
		name {lauraSwingingRt}
		x 185
		y 187
		view 504
		loop 1
		cel 8
	)
)

(instance lauraSwingingLt of Actor ; UNUSED
	(properties
		name {lauraSwingingLt}
		x 136
		y 185
		view 504
		loop 2
		cel 9
	)
)

(instance bobPortrait of Feature
	(properties
		name {bobPortrait}
		x 50
		y 128
		noun 2
		nsTop 106
		nsLeft 33
		nsBottom 151
		nsRight 67
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gMessager say: 24 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance rickPortrait of Feature
	(properties
		name {rickPortrait}
		x 153
		y 113
		noun 4
		nsTop 102
		nsLeft 136
		nsBottom 124
		nsRight 170
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gMessager say: 24 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance leftWall of Feature
	(properties
		name {leftWall}
		y 1
		noun 7
		sightAngle 40
		onMeCheck 4
	)
)

(instance dennisPortrait of Feature
	(properties
		name {dennisPortrait}
		x 200
		y 1
		noun 3
		sightAngle 40
		onMeCheck 256
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gMessager say: 24 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance suziPortrait of Feature
	(properties
		name {suziPortrait}
		x 240
		y 1
		noun 5
		sightAngle 40
		onMeCheck 8
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gMessager say: 24 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance boschPortrait of Feature
	(properties
		name {boschPortrait}
		x 270
		y 100
		noun 9
		sightAngle 40
		onMeCheck 16
	)

	(method (doVerb param1)
		(switch param1
			(8
				(gCurRoom setScript: sBoschPainting)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance skeletonKey of Feature ; UNUSED
	(properties
		name {skeletonKey}
		x 270
		y 100
		noun 17
		sightAngle 40
		onMeCheck 16
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gCurRoom setScript: sBoschPainting)
			)
			(8
				(gCurRoom setScript: sBoschPainting)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance erwinPortrait of Feature
	(properties
		name {erwinPortrait}
		x 380
		y 100
		noun 6
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gMessager say: 24 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance johnPortrait of Feature
	(properties
		name {johnPortrait}
		x 380
		y 160
		noun 1
		sightAngle 40
		onMeCheck 64
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gMessager say: 24 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance bench of Feature
	(properties
		name {bench}
		y 1
		noun 10
		sightAngle 40
		onMeCheck 128
	)
)

(instance sculpture1 of Feature
	(properties
		name {sculpture1}
		y 1
		noun 11
		sightAngle 40
		onMeCheck 1024
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gMessager say: 25 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance sculpture2 of Feature
	(properties
		name {sculpture2}
		y 1
		noun 12
		sightAngle 40
		onMeCheck 512
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gMessager say: 25 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance ceiling of Feature
	(properties
		name {ceiling}
		y 1
		noun 13
		sightAngle 40
		onMeCheck 2048
	)
)

(instance borderCeiling of Feature
	(properties
		name {borderCeiling}
		y 1
		noun 14
		sightAngle 40
		onMeCheck 4096
	)
)

(instance inDeadYvette of Inset
	(properties
		name {inDeadYvette}
		picture 505
		priority 12
	)

	(method (init)
		(super init: &rest)
		(SetFlag 68)
		(SetFlag 161)
		(= local2 gDoVerbCode)
		(= gDoVerbCode exitDoVerbCode)
		(proc0_8 1)
		(gWalkHandler addToFront: self)
		(gTheIconBar disable: 7)
		(if (not (gEgo has: 26))
			(bifocals init:)
		)
		(if (not (gEgo has: 27))
			(redHair init:)
		)
		(feHair init:)
		(feScarf init:)
		(feFace init:)
		(feDress init:)
		(feCleavage init:)
		(feBody init:)
		(feLtHand init:)
		(feRtHand init:)
		(feTowel init:)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gTheIconBar enable: 7)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(13
				(= gDoVerbCode local2)
				(self dispose:)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance exitDoVerbCode of Code
	(properties
		name {exitDoVerbCode}
	)

	(method (doit param1 param2)
		(if (== param1 13)
			(= gDoVerbCode local2)
			(inDeadYvette dispose:)
		else
			(proc0_6 param2 param1)
		)
	)
)

(instance bifocals of View
	(properties
		name {bifocals}
		x 102
		y 156
		noun 22
		view 505
		priority 13
		signal 16400
	)

	(method (doVerb param1)
		(switch param1
			(8
				(if (not (gEgo has: 26))
					(inDeadYvette setInset: inBifocals)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance inBifocals of Inset
	(properties
		name {inBifocals}
		view 505
		loop 1
		x 90
		y 135
		disposeNotOnMe 1
		noun 37
	)

	(method (init)
		(super init: &rest)
		(if (not (gEgo has: 26))
			(bifocals hide:)
			(viBifocals init:)
		)
	)
)

(instance viBifocals of View
	(properties
		name {viBifocals}
		x 103
		y 156
		noun 38
		view 505
		loop 1
		cel 1
		priority 15
		signal 16400
	)

	(method (dispose)
		(if (not (gEgo has: 26))
			(bifocals show:)
		)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gGame points: 1 162)
				((ScriptID 21 0) doit: 795) ; addCluesCode
				(gEgo get: 26)
				(bifocals dispose:)
				(inBifocals dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance redHair of View
	(properties
		name {redHair}
		x 161
		y 152
		noun 23
		view 505
		loop 2
		priority 13
		signal 16400
	)

	(method (doVerb param1)
		(switch param1
			(8
				(if (not (gEgo has: 27))
					(inDeadYvette setInset: inRedHair)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance inRedHair of Inset
	(properties
		name {inRedHair}
		view 505
		loop 3
		x 144
		y 146
		disposeNotOnMe 1
		noun 35
	)

	(method (init)
		(super init: &rest)
		(if (not (gEgo has: 27))
			(redHair hide:)
			(viRedHair init:)
		)
	)
)

(instance viRedHair of View
	(properties
		name {viRedHair}
		x 155
		y 155
		noun 39
		view 505
		loop 3
		cel 1
		priority 15
		signal 16400
	)

	(method (dispose)
		(if (not (gEgo has: 27))
			(redHair show:)
		)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gGame points: 1 160)
				(gEgo get: 27)
				((ScriptID 21 0) doit: 796) ; addCluesCode
				(redHair dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance feHair of Feature
	(properties
		name {feHair}
		y 1
		noun 29
		sightAngle 40
		onMeCheck 16384
	)
)

(instance feScarf of Feature
	(properties
		name {feScarf}
		y 1
		noun 30
		sightAngle 40
		onMeCheck 8192
	)
)

(instance feFace of Feature
	(properties
		name {feFace}
		y 1
		noun 31
		sightAngle 40
		onMeCheck 4096
	)
)

(instance feDress of Feature
	(properties
		name {feDress}
		y 1
		noun 32
		sightAngle 40
		onMeCheck 2048
	)
)

(instance feCleavage of Feature
	(properties
		name {feCleavage}
		y 1
		noun 33
		sightAngle 40
		onMeCheck 1024
	)
)

(instance feBody of Feature
	(properties
		name {feBody}
		y 1
		noun 34
		sightAngle 40
		onMeCheck 512
	)
)

(instance feLtHand of Feature
	(properties
		name {feLtHand}
		y 1
		noun 35
		sightAngle 40
		onMeCheck 256
	)
)

(instance feRtHand of Feature
	(properties
		name {feRtHand}
		y 1
		noun 36
		sightAngle 40
		onMeCheck 128
	)
)

(instance feTowel of Feature
	(properties
		name {feTowel}
		y 1
		noun 37
		sightAngle 40
		onMeCheck 64
	)
)

(instance inBoschPainting of Inset
	(properties
		name {inBoschPainting}
		picture 501
		hideTheCast 1
		noun 19
	)

	(method (init)
		(super init: &rest)
		(proc0_8 1)
		(gWalkHandler addToFront: self)
		(if (not (gEgo has: 8))
			(keyGlintInset init: setScript: sKeyGlintInset)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(13
				(self dispose:)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance inSkeletonKey of Inset
	(properties
		name {inSkeletonKey}
		view 500
		loop 1
		x 179
		y 93
		disposeNotOnMe 1
		noun 18
	)

	(method (doVerb param1)
		(switch param1
			(22
				(if (MuseumRgn nobodyAround:)
					(gGame points: 1 146)
					(gEgo get: -1 8)
					((ScriptID 21 0) doit: 777) ; addCluesCode
					(sFX number: 501 play:)
					(keyGlintInset dispose:)
					(keyGlint setScript: 0)
					(gMessager say: 18 22)
					(self dispose:)
					(return 1)
				else
					(return 1)
				)
			)
			(21
				(if (MuseumRgn nobodyAround:)
					(gGame points: 1 146)
					(gEgo get: -1 8)
					((ScriptID 21 0) doit: 777) ; addCluesCode
					(sFX number: 501 play:)
					(keyGlintInset dispose:)
					(keyGlint setScript: 0)
					(gMessager say: 18 21)
					(self dispose:)
					(return 1)
				else
					(return 1)
				)
			)
			(25
				(gMessager say: 18 25)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance sMeeting of Script
	(properties
		name {sMeeting}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveFwd 15 self)
				(= cycles 5)
			)
			(1
				(gMessager say: 3 0 0 0 self 1500)
			)
			(2)
			(3
				(gEgo setMotion: PolyPath 166 179 self)
			)
			(4
				(= cycles 3)
			)
			(5
				(gMessager say: 2 0 0 0 self 1500)
			)
			(6
				((ScriptID 32 0) setHeading: 270 self) ; aHeimlich
			)
			(7
				(gMessager say: 1 0 0 0 self 1500)
			)
			(8
				(gEgo setHeading: 180 self)
			)
			(9
				(if (TimeCheck $0080)
					(gGameMusic2 number: 502 loop: 1 flags: 1 play: self)
				)
				(gEgo setMotion: MoveFwd 70 self)
			)
			(10
				(if (not (TimeCheck $0080))
					(gGameMusic2 fade:)
					(WrapMusic pause: 0)
					(= cycles 1)
				)
			)
			(11
				(SetFlag 85)
				((ScriptID 90 3) moveTo: local3 cue: 0) ; aORiley, resume patrol (PLAY-036)
				(gCurRoom newRoom: (gCurRoom south:))
				(self dispose:)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties
		name {sEnterSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gEgo setMotion: MoveFwd 20 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties
		name {sEnterNorth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if (== gAct 2)
					((ScriptID 32 0) ; aHeimlich
						originalView: 814
						room: gCurRoomNum
						init:
						posn: 130 180
						setLoop: 8
						setCel: 3
						noun: 1
					)
					(gGameMusic1 pause:)
					(gGameMusic2 number: 19 flags: 1 setLoop: 1 play:)
				)
				(gEgo setMotion: MoveFwd 15 self)
			)
			(1
				(if (gCast contains: (ScriptID 32 0)) ; aHeimlich
					(Face (ScriptID 32 0) gEgo self) ; aHeimlich
				else
					(= cycles 1)
				)
			)
			(2
				(= cycles 5)
			)
			(3
				(if (> gAct 2)
					(if
						(not
							(and
								(== gAct 3)
								(TimeCheck $2140) ; has 2:15 am occurred?
								(not (IsFlag 85))
							)
						)
						(gGame handsOn:)
					)
					(self dispose:)
				else
					(gMessager say: 3 0 84 0 self 1889)
				)
			)
			(4
				(gEgo
					setMotion:
						PolyPath
						(gEgo x:)
						(- (gEgo y:) 15)
						self
				)
			)
			(5
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sSmashPlaster of Script
	(properties
		name {sSmashPlaster}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 185 187 self)
			)
			(1
				(gEgo view: 504 loop: 1 cel: 0 setCycle: CT 10 1 self)
			)
			(2
				(gEgo setCycle: End self)
				(sFX number: 500 play:)
				(yvetteStatue setCycle: End self)
			)
			(3 0)
			(4
				((ScriptID 22 0) doit: 12548) ; triggerAndClock
				(gGame points: 1 161)
				(gEgo normalize: 831)
				(yvetteStatue stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDeadYvette of Script
	(properties
		name {sDeadYvette}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gTheIconBar disable: 7)
				(gCast eachElementDo: 102)
				(gEgo stopUpd:)
				(WrapMusic pause: 1)
				(if (IsFlag 68)
					(fooSound number: 6 loop: -1 flags: 1 play:)
					(= cycles 1)
				else
					(SetFlag 68)
					(SetFlag 161)
					(gCurRoom drawPic: 556)
					(wrapMusic init: -1 3 6)
					(= local0 1)
					(sFX number: 84 flags: 5 loop: 1 play:)
					(= ticks 180)
				)
			)
			(1
				(gCurRoom setInset: inDeadYvette self)
			)
			(2
				(gEgo startUpd:)
				(gCast eachElementDo: 216)
				(gCurRoom drawPic: 500)
				(= cycles 1)
			)
			(3
				(fooSound fade: 0 12 30 1)
				(if local0
					(wrapMusic dispose: 1)
				)
				(WrapMusic pause: 0)
				(proc0_8 0)
				(gTheIconBar enable: 7)
				(self dispose:)
			)
		)
	)
)

(instance sBoschPainting of Script
	(properties
		name {sBoschPainting}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gCurRoom setInset: inBoschPainting self)
			)
			(1
				(if (gEgo has: 8)
					(keyGlint dispose:)
				)
				(= cycles 1)
			)
			(2
				(proc0_8 0)
				(self dispose:)
			)
		)
	)
)

(instance sKeyGlint of Script
	(properties
		name {sKeyGlint}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= cycles 2)
			)
			(1
				(= ticks 300)
			)
			(2
				(if (and (> (gEgo y:) 168) (< (gEgo y:) 187))
					(keyGlint setCel: 0 setCycle: End)
					(= ticks (* 60 (Random 3 10)))
				else
					(= cycles 1)
				)
			)
			(3
				(self changeState: 2)
			)
		)
	)
)

(instance sKeyGlintInset of Script
	(properties
		name {sKeyGlintInset}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(keyGlintInset setCel: 0 setCycle: End)
				(= ticks (* 60 (Random 2 5)))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties
		name {wrapMusic}
	)

	(method (init)
		(= wrapSound fooSound)
		(super init: &rest)
	)
)

(instance fooSound of Sound
	(properties
		name {fooSound}
	)
)

(instance sFX of Sound
	(properties
		name {sFX}
		flags 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 26
	)
)
