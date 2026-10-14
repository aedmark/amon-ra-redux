;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (if param2 global157 else global162))
	(switch param1
		(fIntro
			(Display
				(Localize
					{EINLEITUNG}
					{INTRODUCTION}
					{INTRODUCTION}
					{INTRODUCTION}
					{INTRODUCTION}
				)
				dsCOORD
				(Localize 196 187 187 187 187)
				103
				dsFONT
				61
				dsCOLOR
				global151
			)
			(Display
				(Localize
					{EINLEITUNG}
					{INTRODUCTION}
					{INTRODUCTION}
					{INTRODUCTION}
					{INTRODUCTION}
				)
				dsCOORD
				(Localize 196 187 187 187 187)
				103
				dsFONT
				60
				dsCOLOR
				temp0
			)
		)
		(fPlay
			(Display
				(Localize
					{SPIELSTART}
					{PLAY GAME}
					{PLAY GAME}
					{PLAY GAME}
					{PLAY GAME}
				)
				dsCOORD
				(Localize 197 200 200 200 200)
				113
				dsFONT
				61
				dsCOLOR
				global151
			)
			(Display
				(Localize
					{SPIELSTART}
					{PLAY GAME}
					{PLAY GAME}
					{PLAY GAME}
					{PLAY GAME}
				)
				dsCOORD
				(Localize 197 200 200 200 200)
				113
				dsFONT
				60
				dsCOLOR
				temp0
			)
		)
		(fContinue
			(Display
				(Localize
					{LADEN}
					{RESUME CASE}
					{RESUME CASE}
					{RESUME CASE}
					{RESUME CASE}
				)
				dsCOORD
				(Localize 216 190 190 190 190)
				123
				dsFONT
				61
				dsCOLOR
				global151
			)
			(Display
				(Localize
					{LADEN}
					{RESUME CASE}
					{RESUME CASE}
					{RESUME CASE}
					{RESUME CASE}
				)
				dsCOORD
				(Localize 216 190 190 190 190)
				123
				dsFONT
				60
				dsCOLOR
				temp0
			)
		)
		(fQuit
			(Display
				(Localize {ENDE} {QUIT} {QUIT} {QUIT} {QUIT})
				dsCOORD
				220
				133
				dsFONT
				61
				dsCOLOR
				global151
			)
			(Display
				(Localize {ENDE} {QUIT} {QUIT} {QUIT} {QUIT})
				dsCOORD
				220
				133
				dsFONT
				60
				dsCOLOR
				temp0
			)
		)
	)
)

(instance rm100 of LBRoom
	(properties
		name {rm100}
		picture 100
	)

	(method (init)
		(LoadMany rsVIEW 108 151 101)
		(LoadMany rsSOUND 100 20 23)
		(LoadMany rsSCRIPT 964)
		(self setRegions: 92)
		(Palette palSET_INTENSITY 0 255 0)
		(super init:)
		(gTheIconBar disable:)
		(= local1 (Graph grSAVE_BOX 99 185 142 319 1))
		(= local2 (Graph grSAVE_BOX 123 151 133 185 1))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(lauraBowTitle init:)
		(fIntro init:)
		(fPlay init:)
		(fContinue init:)
		(fQuit init:)
		(self setScript: sStart)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if script
		else
			(= temp0 (gFeatures firstTrue: 218 gMouseX (- gMouseY 10)))
			(if (and (IsObject temp0) (!= temp0 local0))
				(localproc_0 local0 0)
				(localproc_0 temp0 1)
				(= local0 temp0)
			)
		)
	)

	(method (handleEvent param1 &tmp temp0 temp1 temp2)
		(= temp1 (param1 type:))
		(= temp0 (param1 message:))
		(cond
			(
				(or
					(and (== temp1 1) (not (param1 modifiers:)))
					(and (== temp1 4) (== temp0 13))
				)
				(param1 claimed: 1)
				(switch local0
					(fIntro
						(Graph grRESTORE_BOX local1)
						(Graph grRESTORE_BOX local2)
						(Graph grUPDATE_BOX 99 185 142 319 1)
						(Graph grUPDATE_BOX 123 151 133 185 1)
						(gCurRoom setScript: sCartoon)
					)
					(fPlay
						(gEgo get: -1 2)
						(gCurRoom setScript: sCartoon)
					)
					(fContinue
						(gGame restore:)
						(localproc_0 fIntro 0)
						(localproc_0 fPlay 0)
						(localproc_0 fContinue 0)
						(localproc_0 fQuit 0)
						(gMouseDownHandler addToFront: self)
						(gKeyDownHandler addToFront: self)
						(gDirectionHandler addToFront: self)
					)
					(fQuit
						(= gQuit 1)
					)
				)
			)
			((not (& temp1 $0040)))
			((== temp0 1)
				(localproc_0 local0 0)
				(if (>= (= temp2 (- (gFeatures indexOf: local0) 1)) 0)
					(= local0 (gFeatures at: temp2))
				else
					(= local0 (gFeatures at: (- (gFeatures size:) 1)))
				)
				(localproc_0 local0 1)
			)
			((== temp0 5)
				(localproc_0 local0 0)
				(if
					(<
						(= temp2 (+ (gFeatures indexOf: local0) 1))
						(gFeatures size:)
					)
					(= local0 (gFeatures at: temp2))
				else
					(= local0 (gFeatures at: 0))
				)
				(localproc_0 local0 1)
			)
		)
	)

	(method (newRoom)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gUser canInput: 0 canControl: 0)
		(super newRoom: &rest)
	)
)

(instance sStart of Script
	(properties
		name {sStart}
	)

	(method (doit)
		(if (< local3 100)
			(Palette palSET_INTENSITY 0 255 (++ local3))
			(if (== local3 100)
				(self cue:)
			)
		)
		(super doit:)
	)

	(method (changeState param1)
		(switch (= state param1)
			(0 0)
			(1
				(gGame setCursor: 996)
				(gUser canInput: 1 canControl: 1)
				(gGameMusic1 number: 20 flags: 1 play:)
				(localproc_0 fIntro 0)
				(= ticks 40)
			)
			(2
				(localproc_0 fPlay 0)
				(= ticks 40)
			)
			(3
				(localproc_0 fContinue 0)
				(= ticks 40)
			)
			(4
				(localproc_0 fQuit 0)
				(= ticks 120)
			)
			(5
				(gGameMusic1 number: 23 flags: 1 play:)
				(localproc_0 fPlay 1)
				(= local0 fPlay)
				(gGame setCursor: 999)
				(self dispose:)
			)
		)
	)
)

(instance sCartoon of Script
	(properties
		name {sCartoon}
	)

	(method (doit)
		(if (and local4 local3)
			(Palette palSET_INTENSITY 0 255 (-- local3))
			(if (not local3)
				(self cue:)
			)
		)
		(super doit:)
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if (== local0 fPlay)
					(self changeState: 18)
				else
					(sparkle init:)
					(wake init: setCycle: RTRandCycle)
					(smoke init: setCycle: RTRandCycle)
					(gGameMusic1 number: 100 loop: 1 flags: 1 play: self)
					(gGame handsOff: setCursor: 996 1 304 172)
					(= seconds 3)
				)
			)
			(1
				(sparkle
					setLoop: 2
					setCycle: Fwd
					setMotion:
						DPath
						17
						93
						39
						91
						55
						95
						116
						115
						138
						117
						160
						113
						167
						101
						161
						94
						self
				)
			)
			(2
				(sparkle setLoop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(sparkle setLoop: 2 setCel: 0 posn: 84 27 setCycle: End self)
			)
			(4
				(sparkle
					ignoreControl: -32768
					setLoop: 2
					setCel: 0
					posn: 66 153
					setCycle: End self
				)
			)
			(5
				(= seconds 4)
			)
			(6
				(lauraBowTitle dispose:)
				(sparkle dispose:)
				(creditTitle init: setMotion: MoveTo 12 102 self)
				(creditName init: setMotion: MoveTo 164 128 self)
			)
			(7 0)
			(8
				(= seconds 4)
			)
			(9
				(creditTitle setMotion: MoveTo -222 102 self)
				(creditName setMotion: MoveTo 398 128 self)
			)
			(10 0)
			(11
				(= seconds 3)
			)
			(12
				(creditTitle init: loop: 1 setMotion: MoveTo 12 102 self)
				(creditName init: loop: 1 setMotion: MoveTo 164 128 self)
			)
			(13 0)
			(14
				(= seconds 4)
			)
			(15
				(creditTitle setMotion: MoveTo 12 210 self)
				(creditName setMotion: MoveTo 164 236 self)
			)
			(16 0)
			(17 0)
			(18
				(= local4 1)
			)
			(19
				(gCurRoom newRoom: (if (== local0 fPlay) 26 else 110))
			)
		)
	)
)

(instance fIntro of Feature
	(properties
		name {fIntro}
		x 263
		y 104
		nsTop 103
		nsLeft 208
		nsBottom 113
		nsRight 318
	)
)

(instance fPlay of Feature
	(properties
		name {fPlay}
		x 263
		y 104
		nsTop 113
		nsLeft 208
		nsBottom 123
		nsRight 318
	)
)

(instance fContinue of Feature
	(properties
		name {fContinue}
		x 263
		y 104
		nsTop 123
		nsLeft 208
		nsBottom 133
		nsRight 318
	)
)

(instance fQuit of Feature
	(properties
		name {fQuit}
		x 263
		y 104
		nsTop 133
		nsLeft 208
		nsBottom 143
		nsRight 318
	)
)

(instance lauraBowTitle of View
	(properties
		name {lauraBowTitle}
		y 156
		view 101
	)
)

(instance smoke of Prop
	(properties
		name {smoke}
		x 204
		y 59
		view 101
		loop 1
		cycleSpeed 20
	)
)

(instance wake of Prop
	(properties
		name {wake}
		x 230
		y 91
		view 101
		loop 2
		cycleSpeed 20
	)
)

(instance creditTitle of Actor
	(properties
		name {creditTitle}
		x 12
		y 190
		view 151
		signal 2048
		moveSpeed 0
	)
)

(instance creditName of Actor
	(properties
		name {creditName}
		x 164
		y 216
		view 151
		cel 1
		signal 2048
		moveSpeed 0
	)
)

(instance sparkle of Actor
	(properties
		name {sparkle}
		y 100
		view 108
		loop 2
		priority 15
		signal 16400
		cycleSpeed 4
		moveSpeed 4
	)
)
