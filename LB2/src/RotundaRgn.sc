;;; Sierra Script 1.0 - (do not remove this comment)
(script# 93)
(include sci.sh)
(use Main)
(use n027)
(use Game)
(use View)
(use Obj)

(public
	RotundaRgn 0
	Countess 1
	proc93_2 2
	Heimlich 3
	Olympia 4
	O_Riley 5
	Pippin 6
	Rameses 7
	Steve 8
	Tut 9
	Watney 10
	Yvette 11
	Ziggy 12
)

(procedure (proc93_2)
)

(class RotundaRgn of Rgn
	(properties
		sel_20 {RotundaRgn}
		sel_142 0
		sel_40 0
		sel_214 -1
		sel_213 0
		sel_135 0
		sel_406 0
		sel_407 0
		sel_667 0
		sel_668 0
	)
	
	(method (sel_110)
		(super sel_110:)
		(= sel_667
			(switch global128
				(0 350)
				(1 350)
				(2 360)
				(3 360)
				(4 350)
				(5 350)
				(6 370)
				(7 370)
				(8 370)
				(9 350)
				(10 360)
				(11 360)
				(12 360)
				(13 350)
			)
		)
		(Countess sel_305: 20 sel_311: 2 6)
		(Heimlich sel_305: 20 sel_311: 2 6)
		(Olympia sel_305: 20 sel_311: 2 6)
		(O_Riley sel_305: 20 sel_311: 2 6)
		(Pippin sel_305: 20 sel_311: 2 6)
		(Rameses sel_305: 20 sel_311: 2 6)
		(Steve sel_305: 20 sel_311: 2 6)
		(Tut sel_305: 20 sel_311: 2 6)
		(Watney sel_305: 20 sel_311: 2 6)
		(Yvette sel_305: 20 sel_311: 2 6)
		(Ziggy sel_305: 20 sel_311: 2 6)
	)
	
	(method (sel_399 param1)
		(= sel_406
			(proc999_5 param1 335 340 350 355 360 370 400)
		)
		(= sel_407 0)
		(cond 
			((not (== global123 2)))
			((proc999_5 param1 335 400 420) (gSel_608 sel_170: 50 5 5 0))
			((== param1 340) (gSel_608 sel_170: 100 5 5 0))
		)
		(if
			(and
				(& $7204 global124)
				(not (proc0_2 71))
				(== param1 360)
			)
			(proc0_3 71)
		)
		(super sel_399: param1)
	)
	
	(method (sel_403)
		(= sel_668 gSel_40)
		(global2 sel_399: 340)
	)
)

(instance Countess of Actor
	(properties
		sel_20 {Countess}
		sel_213 1
		sel_214 1884
		sel_2 813
		sel_14 16384
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 269)
		)
		(cond 
			((== param1 2)
				(if (not (proc0_3 112))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(super sel_300: param1)
				)
			)
			((proc999_5 param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(global2 sel_422: (ScriptID 20 0))
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256 (+ temp2 1))
						(512 (+ temp2 18))
						(768 (+ temp2 26))
						(1024 (+ temp2 61))
					)
				)
				(cond 
					(
					(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
					((proc27_0 0 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
					(else
						(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
						(proc27_1 0 @[global296 (- temp1 2)])
					)
				)
			)
			(else (super sel_300: param1))
		)
	)
)

(instance Heimlich of Actor
	(properties
		sel_20 {Heimlich}
		sel_213 1
		sel_214 1889
		sel_2 814
		sel_14 16384
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 265)
		)
		(if (proc999_5 param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(cond 
				(
				(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
				((proc27_0 2 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
				(else
					(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
					(proc27_1 2 @[global296 (- temp1 2)])
				)
			)
		else
			(super sel_300: param1)
		)
	)
)

(instance Olympia of Actor
	(properties
		sel_20 {Olympia}
		sel_213 1
		sel_214 1892
		sel_2 820
		sel_14 16384
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 270)
		)
		(if (proc999_5 param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(cond 
				(
				(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
				((proc27_0 3 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
				(else
					(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
					(proc27_1 3 @[global296 (- temp1 2)])
				)
			)
		else
			(super sel_300: param1)
		)
	)
)

(instance O_Riley of Actor
	(properties
		sel_20 {O'Riley}
		sel_213 1
		sel_214 1888
		sel_2 819
		sel_14 16384
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 260)
		)
		(cond 
			((== param1 2)
				(if (not (proc0_3 114))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(super sel_300: param1)
				)
			)
			((proc999_5 param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(global2 sel_422: (ScriptID 20 0))
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256 (+ temp2 1))
						(512 (+ temp2 18))
						(768 (+ temp2 26))
						(1024 (+ temp2 61))
					)
				)
				(switch temp0
					(258
						(cond 
							((proc0_2 134)
								(if (proc27_0 4 global364)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 72 0 0 sel_214)
									(proc27_1 4 @global364)
								)
							)
							((proc27_0 4 global297) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 3 0 0 sel_214)
								(proc27_1 4 @global297)
							)
						)
					)
					(259
						(cond 
							((proc0_2 171)
								(if (proc27_0 4 global363)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 69 0 0 sel_214)
									(proc27_1 4 @global363)
								)
							)
							((proc27_0 4 global298) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 4 0 0 sel_214)
								(proc27_1 4 @global298)
							)
						)
					)
					(264
						(cond 
							((proc0_2 143)
								(if (proc27_0 4 global366)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 74 0 0 sel_214)
									(proc27_1 4 @global366)
								)
							)
							((proc27_0 4 global303) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 9 0 0 sel_214)
								(proc27_1 4 @global303)
							)
						)
					)
					(266
						(cond 
							((proc0_2 161)
								(if (proc27_0 4 global367)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 73 0 0 sel_214)
									(proc27_1 4 @global367)
								)
							)
							((proc27_0 4 global305) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 11 0 0 sel_214)
								(proc27_1 4 @global305)
							)
						)
					)
					(267
						(cond 
							((proc0_2 158)
								(if (proc27_0 4 global365)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 71 0 0 sel_214)
									(proc27_1 4 @global365)
								)
							)
							((proc27_0 4 global306) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 12 0 0 sel_214)
								(proc27_1 4 @global306)
							)
						)
					)
					(780
						(cond 
							((proc0_2 155)
								(if (proc27_0 4 global368)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 75 0 0 sel_214)
									(proc27_1 4 @global368)
								)
							)
							((proc27_0 4 global332) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 38 0 0 sel_214)
								(proc27_1 4 @global332)
							)
						)
					)
					(else 
						(cond 
							(
							(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
							((proc27_0 4 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
								(proc27_1 4 @[global296 (- temp1 2)])
							)
						)
					)
				)
			)
			(else (super sel_300: param1))
		)
	)
)

(instance Pippin of Actor
	(properties
		sel_20 {Pippin}
		sel_213 1
		sel_214 1882
		sel_2 822
		sel_14 16384
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 258)
		)
		(cond 
			((== param1 2)
				(if (not (proc0_3 110))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(super sel_300: param1)
				)
			)
			((proc999_5 param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(global2 sel_422: (ScriptID 20 0))
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256 (+ temp2 1))
						(512 (+ temp2 18))
						(768 (+ temp2 26))
						(1024 (+ temp2 61))
					)
				)
				(cond 
					(
					(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
					((proc27_0 5 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
					(else
						(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
						(proc27_1 5 @[global296 (- temp1 2)])
					)
				)
			)
			(else (super sel_300: param1))
		)
	)
)

(instance Rameses of Actor
	(properties
		sel_20 {Rameses}
		sel_213 1
		sel_214 1891
		sel_2 823
		sel_14 16384
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 268)
		)
		(cond 
			((== param1 2)
				(if (not (proc0_3 115))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(super sel_300: param1)
				)
			)
			((proc999_5 param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(global2 sel_422: (ScriptID 20 0))
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256 (+ temp2 1))
						(512 (+ temp2 18))
						(768 (+ temp2 26))
						(1024 (+ temp2 61))
					)
				)
				(cond 
					(
					(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
					((proc27_0 6 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
					(else
						(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
						(proc27_1 6 @[global296 (- temp1 2)])
					)
				)
			)
			(else (super sel_300: param1))
		)
	)
)

(instance Steve of Actor
	(properties
		sel_20 {Steve}
		sel_213 1
		sel_214 1887
		sel_2 812
		sel_14 16384
		sel_103 1
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 263)
		)
		(if (== param1 6)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(cond 
				(
				(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
				((proc27_0 10 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
				(else
					(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
					(proc27_1 10 @[global296 (- temp1 2)])
				)
			)
		else
			(super sel_300: param1)
		)
	)
)

(instance Tut of Actor
	(properties
		sel_20 {Tut}
		sel_213 1
		sel_214 1883
		sel_2 821
		sel_14 16384
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 271)
		)
		(cond 
			((== param1 2)
				(if (not (proc0_3 111))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(super sel_300: param1)
				)
			)
			((proc999_5 param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(global2 sel_422: (ScriptID 20 0))
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256 (+ temp2 1))
						(512 (+ temp2 18))
						(768 (+ temp2 26))
						(1024 (+ temp2 61))
					)
				)
				(cond 
					(
					(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
					((proc27_0 7 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
					(else
						(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
						(proc27_1 7 @[global296 (- temp1 2)])
					)
				)
			)
			(else (super sel_300: param1))
		)
	)
)

(instance Watney of Actor
	(properties
		sel_20 {Watney}
		sel_213 1
		sel_214 1886
		sel_2 815
		sel_14 16384
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 272)
		)
		(if (== param1 6)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(cond 
				(
				(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
				((proc27_0 8 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
				(else
					(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
					(proc27_1 8 @[global296 (- temp1 2)])
				)
			)
		else
			(super sel_300: param1)
		)
	)
)

(instance Yvette of Actor
	(properties
		sel_20 {Yvette}
		sel_213 1
		sel_214 1885
		sel_2 817
		sel_14 16384
		sel_103 1
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 266)
		)
		(cond 
			((== param1 2)
				(if (not (proc0_3 113))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(gLb2Messager sel_295: sel_213 param1 28 0 0 sel_214)
				)
			)
			((proc999_5 param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(global2 sel_422: (ScriptID 20 0))
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256 (+ temp2 1))
						(512 (+ temp2 18))
						(768 (+ temp2 26))
						(1024 (+ temp2 61))
					)
				)
				(switch temp0
					(267
						(cond 
							((proc0_2 158)
								(if (proc27_0 9 global365)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 71 0 0 sel_214)
									(proc27_1 9 @global365)
								)
							)
							((proc27_0 9 global306) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 12 0 0 sel_214)
								(proc27_1 9 @global306)
							)
						)
					)
					(263
						(if (proc27_0 9 global302)
							(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
						else
							(gLb2Messager sel_295: sel_213 6 8 0 0 sel_214)
							(proc27_1 9 @global302)
						)
					)
					(else 
						(cond 
							(
							(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
							((proc27_0 9 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
								(proc27_1 9 @[global296 (- temp1 2)])
							)
						)
					)
				)
			)
			(else (super sel_300: param1))
		)
	)
)

(instance Ziggy of Actor
	(properties
		sel_20 {Ziggy}
		sel_213 1
		sel_214 1890
		sel_2 816
		sel_14 16384
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 1 2)
			((ScriptID 21 0) sel_57: 264)
		)
		(if (proc999_5 param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(cond 
				(
				(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
				((proc27_0 11 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
				(else
					(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
					(proc27_1 11 @[global296 (- temp1 2)])
				)
			)
		else
			(super sel_300: param1)
		)
	)
)
