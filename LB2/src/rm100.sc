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
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
				)
				dsCOORD
				(Localize 216 170 170 170 170)
				123
				dsFONT
				61
				dsCOLOR
				global151
			)
			(Display
				(Localize
					{LADEN}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
				)
				dsCOORD
				(Localize 216 170 170 170 170)
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
		sel_20 {rm100}
		sel_408 100
	)

	(method (sel_110)
		(LoadMany rsVIEW 108 151 101)
		(LoadMany rsSOUND 100 20 23)
		(LoadMany rsSCRIPT 964)
		(self sel_414: 92)
		(Palette palSET_INTENSITY 0 255 0)
		(super sel_110:)
		(gTheIconBar sel_233:)
		(= local1 (Graph grSAVE_BOX 99 185 142 319 1))
		(= local2 (Graph grSAVE_BOX 123 151 133 185 1))
		(gMouseDownHandler sel_129: self)
		(gKeyDownHandler sel_129: self)
		(gDirectionHandler sel_129: self)
		(lauraBowTitle sel_110:)
		(fIntro sel_110:)
		(fPlay sel_110:)
		(fContinue sel_110:)
		(fQuit sel_110:)
		(self sel_146: sStart)
	)

	(method (sel_57 &tmp temp0)
		(super sel_57:)
		(if sel_142
		else
			(= temp0 (gFeatures sel_120: 218 gMouseX (- gMouseY 10)))
			(if (and (IsObject temp0) (!= temp0 local0))
				(localproc_0 local0 0)
				(localproc_0 temp0 1)
				(= local0 temp0)
			)
		)
	)

	(method (sel_133 param1 &tmp temp0 temp1 temp2)
		(= temp1 (param1 sel_31:))
		(= temp0 (param1 sel_37:))
		(cond
			(
				(or
					(and (== temp1 1) (not (param1 sel_61:)))
					(and (== temp1 4) (== temp0 13))
				)
				(param1 sel_73: 1)
				(switch local0
					(fIntro
						(Graph grRESTORE_BOX local1)
						(Graph grRESTORE_BOX local2)
						(Graph grUPDATE_BOX 99 185 142 319 1)
						(Graph grUPDATE_BOX 123 151 133 185 1)
						(gCurRoom sel_146: sCartoon)
					)
					(fPlay
						(gEgo sel_350: -1 2)
						(gCurRoom sel_146: sCartoon)
					)
					(fContinue
						(gGame sel_76:)
						(localproc_0 fIntro 0)
						(localproc_0 fPlay 0)
						(localproc_0 fContinue 0)
						(localproc_0 fQuit 0)
						(gMouseDownHandler sel_129: self)
						(gKeyDownHandler sel_129: self)
						(gDirectionHandler sel_129: self)
					)
					(fQuit
						(= gQuit 1)
					)
				)
			)
			((not (& temp1 $0040)))
			((== temp0 1)
				(localproc_0 local0 0)
				(if (>= (= temp2 (- (gFeatures sel_132: local0) 1)) 0)
					(= local0 (gFeatures sel_64: temp2))
				else
					(= local0 (gFeatures sel_64: (- (gFeatures sel_86:) 1)))
				)
				(localproc_0 local0 1)
			)
			((== temp0 5)
				(localproc_0 local0 0)
				(if
					(<
						(= temp2 (+ (gFeatures sel_132: local0) 1))
						(gFeatures sel_86:)
					)
					(= local0 (gFeatures sel_64: temp2))
				else
					(= local0 (gFeatures sel_64: 0))
				)
				(localproc_0 local0 1)
			)
		)
	)

	(method (sel_399)
		(gMouseDownHandler sel_81: self)
		(gKeyDownHandler sel_81: self)
		(gDirectionHandler sel_81: self)
		(gUser sel_347: 0 sel_237: 0)
		(super sel_399: &rest)
	)
)

(instance sStart of Script
	(properties
		sel_20 {sStart}
	)

	(method (sel_57)
		(if (< local3 100)
			(Palette palSET_INTENSITY 0 255 (++ local3))
			(if (== local3 100)
				(self sel_145:)
			)
		)
		(super sel_57:)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0 0)
			(1
				(gGame sel_197: 996)
				(gUser sel_347: 1 sel_237: 1)
				(gGameMusic1 sel_40: 20 sel_99: 1 sel_39:)
				(localproc_0 fIntro 0)
				(= sel_139 40)
			)
			(2
				(localproc_0 fPlay 0)
				(= sel_139 40)
			)
			(3
				(localproc_0 fContinue 0)
				(= sel_139 40)
			)
			(4
				(localproc_0 fQuit 0)
				(= sel_139 120)
			)
			(5
				(gGameMusic1 sel_40: 23 sel_99: 1 sel_39:)
				(localproc_0 fPlay 1)
				(= local0 fPlay)
				(gGame sel_197: 999)
				(self sel_111:)
			)
		)
	)
)

(instance sCartoon of Script
	(properties
		sel_20 {sCartoon}
	)

	(method (sel_57)
		(if (and local4 local3)
			(Palette palSET_INTENSITY 0 255 (-- local3))
			(if (not local3)
				(self sel_145:)
			)
		)
		(super sel_57:)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(if (== local0 fPlay)
					(self sel_144: 18)
				else
					(sparkle sel_110:)
					(wake sel_110: sel_161: RTRandCycle)
					(smoke sel_110: sel_161: RTRandCycle)
					(gGameMusic1 sel_40: 100 sel_3: 1 sel_99: 1 sel_39: self)
					(gGame sel_587: sel_197: 996 1 304 172)
					(= sel_137 3)
				)
			)
			(1
				(sparkle
					sel_155: 2
					sel_161: Fwd
					sel_312:
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
				(sparkle sel_155: 3 sel_156: 0 sel_161: End self)
			)
			(3
				(sparkle sel_155: 2 sel_156: 0 sel_153: 84 27 sel_161: End self)
			)
			(4
				(sparkle
					sel_332: -32768
					sel_155: 2
					sel_156: 0
					sel_153: 66 153
					sel_161: End self
				)
			)
			(5
				(= sel_137 4)
			)
			(6
				(lauraBowTitle sel_111:)
				(sparkle sel_111:)
				(creditTitle sel_110: sel_312: MoveTo 12 102 self)
				(creditName sel_110: sel_312: MoveTo 164 128 self)
			)
			(7 0)
			(8
				(= sel_137 4)
			)
			(9
				(creditTitle sel_312: MoveTo -222 102 self)
				(creditName sel_312: MoveTo 398 128 self)
			)
			(10 0)
			(11
				(= sel_137 3)
			)
			(12
				(creditTitle sel_110: sel_3: 1 sel_312: MoveTo 12 102 self)
				(creditName sel_110: sel_3: 1 sel_312: MoveTo 164 128 self)
			)
			(13 0)
			(14
				(= sel_137 4)
			)
			(15
				(creditTitle sel_312: MoveTo 12 210 self)
				(creditName sel_312: MoveTo 164 236 self)
			)
			(16 0)
			(17 0)
			(18
				(= local4 1)
			)
			(19
				(gCurRoom sel_399: (if (== local0 fPlay) 26 else 110))
			)
		)
	)
)

(instance fIntro of Feature
	(properties
		sel_20 {fIntro}
		sel_1 263
		sel_0 104
		sel_6 103
		sel_7 208
		sel_8 113
		sel_9 318
	)
)

(instance fPlay of Feature
	(properties
		sel_20 {fPlay}
		sel_1 263
		sel_0 104
		sel_6 113
		sel_7 208
		sel_8 123
		sel_9 318
	)
)

(instance fContinue of Feature
	(properties
		sel_20 {fContinue}
		sel_1 263
		sel_0 104
		sel_6 123
		sel_7 208
		sel_8 133
		sel_9 318
	)
)

(instance fQuit of Feature
	(properties
		sel_20 {fQuit}
		sel_1 263
		sel_0 104
		sel_6 133
		sel_7 208
		sel_8 143
		sel_9 318
	)
)

(instance lauraBowTitle of View
	(properties
		sel_20 {lauraBowTitle}
		sel_0 156
		sel_2 101
	)
)

(instance smoke of Prop
	(properties
		sel_20 {smoke}
		sel_1 204
		sel_0 59
		sel_2 101
		sel_3 1
		sel_244 20
	)
)

(instance wake of Prop
	(properties
		sel_20 {wake}
		sel_1 230
		sel_0 91
		sel_2 101
		sel_3 2
		sel_244 20
	)
)

(instance creditTitle of Actor
	(properties
		sel_20 {creditTitle}
		sel_1 12
		sel_0 190
		sel_2 151
		sel_14 2048
		sel_53 0
	)
)

(instance creditName of Actor
	(properties
		sel_20 {creditName}
		sel_1 164
		sel_0 216
		sel_2 151
		sel_4 1
		sel_14 2048
		sel_53 0
	)
)

(instance sparkle of Actor
	(properties
		sel_20 {sparkle}
		sel_0 100
		sel_2 108
		sel_3 2
		sel_60 15
		sel_14 16400
		sel_244 4
		sel_53 4
	)
)
